/*
 * Copyright (c) 1994, 2012, Oracle and/or its affiliates. All rights reserved.
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

package java.util;

/**
 * Thrown by various accessor methods to indicate that the element being requested
 * does not exist.
 * 由各种访问器方法抛出，以指示所请求的元素不存在。
 * @author  unascribed
 * @see     java.util.Enumeration#nextElement()
 * @see     java.util.Iterator#next()
 * @since   JDK1.0
 */
public
class NoSuchElementException extends RuntimeException {
    private static final long serialVersionUID = 6769829250639411880L;

    /**
     * Constructs a <code>NoSuchElementException</code> with <tt>null</tt>
     * as its error message string. 构造一个<code>NoSuchElementException</code>以<tt>null</tt>作为其错误消息字符串。
     */
    public NoSuchElementException() {
        super();
    }

    /**
     * Constructs a <code>NoSuchElementException</code>, saving a reference
     * to the error message string <tt>s</tt> for later retrieval by the
     * <tt>getMessage</tt> method.
     * 构造一个<code>NoSuchElementException</code>，保存一个对错误消息字符串<tt>s</tt>的引用，以便以后通过<tt>getMessage</tt>方法检索。
     * @param   s   the detail message. 详细的消息。
     */
    public NoSuchElementException(String s) {
        super(s);
    }
}
