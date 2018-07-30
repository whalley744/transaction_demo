package whalley.tm.proxy;

import whalley.tm.TransactionManager;

import java.lang.reflect.Proxy;

/**
 * Created by Whalley on 2018/7/30.
 */
public class TransactionProxyManager {

    private TransactionManager transactionManager;

    public TransactionProxyManager(TransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    public Object proxyFor(Object obj) {
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(),
                new TransactionInvocationHandler(obj, transactionManager));
    }

}
