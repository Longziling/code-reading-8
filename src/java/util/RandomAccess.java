/*
 * Copyright (c) 2000, 2006, Oracle and/or its affiliates. All rights reserved.
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
 * Marker interface used by <tt>List</tt> implementations to indicate that
 * they support fast (generally constant time) random access.  The primary
 * purpose of this interface is to allow generic algorithms to alter their
 * behavior to provide good performance when applied to either random or
 * sequential access lists.
 * 列表实现使用的标记接口，表明它们支持快速(通常是固定时间)随机访问。这个接口的主要目的是允许通用算法改变它们的行为，从而在应用于随机或顺序访问列表时提供良好的性能。
 * <p>The best algorithms for manipulating random access lists (such as
 * <tt>ArrayList</tt>) can produce quadratic behavior when applied to
 * sequential access lists (such as <tt>LinkedList</tt>).  Generic list
 * algorithms are encouraged to check whether the given list is an
 * <tt>instanceof</tt> this interface before applying an algorithm that would
 * provide poor performance if it were applied to a sequential access list,
 * and to alter their behavior if necessary to guarantee acceptable
 * performance.
 * 操作随机访问列表(如ArrayList)的最佳算法在应用于顺序访问列表(如LinkedList)时可以产生二次行为。一般列表算法被鼓励在应用一个算法之前检查给定的列表是否是这个接口的一个实例，这个算法如果应用于顺序访问列表，将会提供较差的性能，并在必要时改变它们的行为以保证可接受的性能。
 * <p>It is recognized that the distinction between random and sequential
 * access is often fuzzy.  For example, some <tt>List</tt> implementations
 * provide asymptotically linear access times if they get huge, but constant
 * access times in practice.  Such a <tt>List</tt> implementation
 * should generally implement this interface.  As a rule of thumb, a
 * <tt>List</tt> implementation should implement this interface if,
 * for typical instances of the class, this loop:
 * <pre>
 *     for (int i=0, n=list.size(); i &lt; n; i++)
 *         list.get(i);
 * </pre>
 * runs faster than this loop: 运行速度比这个循环快:
 * <pre>
 *     for (Iterator i=list.iterator(); i.hasNext(); )
 *         i.next();
 * </pre>
 * 众所周知，随机访问和顺序访问之间的区别通常是模糊的。例如，一些<tt>List</tt>的实现在它们非常大的时候提供渐近线性的访问时间，但是在实践中访问时间是恒定的。这样的<tt>List</tt>实现通常应该实现这个接口。作为一个经验法则，一个<tt>List</tt>实现应该实现这个接口，如果，对于类的典型实例，这个循环
 * <p>This interface is a member of the
 * <a href="{@docRoot}/../technotes/guides/collections/index.html">
 * Java Collections Framework</a>.
 *
 * @since 1.4
 */
public interface RandomAccess {
}
