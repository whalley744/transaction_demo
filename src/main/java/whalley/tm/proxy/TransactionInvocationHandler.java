package whalley.tm.proxy;

import whalley.tm.annotation.Transactional;
import whalley.tm.TransactionManager;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by Whalley on 2018/7/30.
 */
public class TransactionInvocationHandler implements InvocationHandler {
    private Object             proxy;
    private TransactionManager transactionManager;

    public TransactionInvocationHandler(Object proxy, TransactionManager transactionManager) {
        this.proxy = proxy;
        this.transactionManager = transactionManager;
    }

    public Object invoke(Object obj, Method method, Object[] args) throws Exception {
        if (method.isAnnotationPresent(Transactional.class)
                || method.getDeclaringClass().isAnnotationPresent(Transactional.class)) {
            try {
                transactionManager.open();
                Object result = method.invoke(proxy, args);
                transactionManager.commit();
                return result;
            } catch (Exception e) {
                transactionManager.rollback();
                throw e;
            } finally {
                transactionManager.close();
            }
        }
        return method.invoke(proxy, args);
    }
}
