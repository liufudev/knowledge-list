package org.lf.javassist;

/**
 * @author liufu
 */
public class JavassistTest {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        System.out.println("*******************方式二*******************");
        JavassistProxyFactory02 jpf02 = new JavassistProxyFactory02();
        Item a2 = (Item) jpf02.getProxy(Item.class);
        a2.del();
        a2.save();

    }

}
