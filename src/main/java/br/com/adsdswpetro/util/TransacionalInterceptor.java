package br.com.adsdswpetro.util;

import java.io.Serializable;

import javax.annotation.Priority;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

@Interceptor
@Transacional
@Priority(Interceptor.Priority.APPLICATION + 1)
public class TransacionalInterceptor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	@AroundInvoke
	public Object invoke(InvocationContext context) throws Exception {
		EntityTransaction trx = manager.getTransaction();
		boolean iniciouTransacao = false;

		try {
			if (!trx.isActive()) {
				// Truque para fazer rollback no que j� passou, sen�o um futuro commit poderia confirmar opera��es sem transa��o
				trx.begin();
				trx.rollback();

				trx.begin();
				iniciouTransacao = true;
			}
			return context.proceed();
		} catch (Exception e) {
			if (trx != null && iniciouTransacao) {
				trx.rollback();
			}
			throw e;
		} finally {
			if (trx != null && trx.isActive() && iniciouTransacao) {
				trx.commit();
			}
		}
	}
}
