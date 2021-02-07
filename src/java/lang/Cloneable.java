/*
 * Copyright (c) 1995, 2004, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */

package java.lang;

/**
 * A class implements the <code>Cloneable</code> interface to
 * indicate to the {@link java.lang.Object#clone()} method that it
 * is legal for that method to make a
 * field-for-field copy of instances of that class. 一个类实现了<code>Cloneable</code>接口来指示{@link java.lang.Object#clone()}方法对该类的实例进行字段对字段的复制是合法的。
 * <p>
 * Invoking Object's clone method on an instance that does not implement the
 * <code>Cloneable</code> interface results in the exception
 * <code>CloneNotSupportedException</code> being thrown. 在没有实现<code>Cloneable</code>接口的实例上调用对象的克隆方法会导致抛出异常<code>CloneNotSupportedException</code>。
 * <p>
 * By convention, classes that implement this interface should override
 * <tt>Object.clone</tt> (which is protected) with a public method.
 * See {@link java.lang.Object#clone()} for details on overriding this
 * method. 按照惯例，实现这个接口的类应该覆盖<tt>Object.clone </tt>(受保护)。关于覆盖这个方法的详细信息，请参见{@link java.lang.Object#clone()}。
 * <p>
 * Note that this interface does <i>not</i> contain the <tt>clone</tt> method.
 * Therefore, it is not possible to clone an object merely by virtue of the
 * fact that it implements this interface.  Even if the clone method is invoked
 * reflectively, there is no guarantee that it will succeed.
 * 注意，这个接口不包含<tt>clone </tt>方法。因此，仅凭一个对象实现了这个接口就克隆它是不可能的。即使反射地调用clone方法，也不能保证它会成功。
 * @author  unascribed
 * @see     java.lang.CloneNotSupportedException
 * @see     java.lang.Object#clone()
 * @since   JDK1.0
 */
public interface Cloneable {
}
