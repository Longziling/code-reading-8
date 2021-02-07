/*
 * Copyright (c) 2003, 2013, Oracle and/or its affiliates. All rights reserved.
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

import java.util.Iterator;
import java.util.Objects;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.Consumer;

/**
 * Implementing this interface allows an object to be the target of
 * the "for-each loop" statement. See 实现这个接口允许一个对象成为"for-each loop"语句的目标。
 * <strong>
 * <a href="{@docRoot}/../technotes/guides/language/foreach.html">For-each Loop</a>
 * </strong>
 *
 * @param <T> the type of elements returned by the iterator 迭代器返回的元素类型
 *
 * @since 1.5
 * @jls 14.14.2 The enhanced for statement 增强的for语句
 */
public interface Iterable<T> {
    /**
     * Returns an iterator over elements of type {@code T}.
     * 返回类型为{@code T}的元素的迭代器。
     * @return an Iterator.
     */
    Iterator<T> iterator();

    /**
     * Performs the given action for each element of the {@code Iterable}
     * until all elements have been processed or the action throws an
     * exception.  Unless otherwise specified by the implementing class,
     * actions are performed in the order of iteration (if an iteration order
     * is specified).  Exceptions thrown by the action are relayed to the
     * caller.
     * 对{@code Iterable}的每个元素执行给定的操作，直到所有元素都被处理或者该操作抛出异常。除非实现类另有规定，操作按照迭代的顺序执行(如果指定了迭代顺序)。动作抛出的异常被转发给调用者。
     * @implSpec
     * <p>The default implementation behaves as if:
     * <pre>{@code
     *     for (T t : this)
     *         action.accept(t);
     * }</pre>
     *
     * @param action The action to be performed for each element 要对每个元素执行的操作
     * @throws NullPointerException if the specified action is null 如果指定的动作为空
     * @since 1.8
     */
    default void forEach(Consumer<? super T> action) {
        Objects.requireNonNull(action);
        for (T t : this) {
            action.accept(t);
        }
    }

    /**
     * Creates a {@link Spliterator} over the elements described by this
     * {@code Iterable}.
     * 在这个{@code Iterable}描述的元素上创建一个{@link Spliterator}。
     * @implSpec
     * The default implementation creates an
     * <em><a href="Spliterator.html#binding">early-binding</a></em>
     * spliterator from the iterable's {@code Iterator}.  The spliterator
     * inherits the <em>fail-fast</em> properties of the iterable's iterator.
     * 默认实现从可迭代对象的{@code Iterator}中创建一个<em><a href>早期绑定</a></em>拆分器。拆分器继承了可迭代对象的迭代器的<em>fail-fast</em>属性。
     * @implNote
     * The default implementation should usually be overridden.  The
     * spliterator returned by the default implementation has poor splitting
     * capabilities, is unsized, and does not report any spliterator
     * characteristics. Implementing classes can nearly always provide a
     * better implementation.
     * 默认的实现通常应该被重写。默认实现返回的spliterator具有较差的拆分能力，未调整大小，并且不报告任何spliterator特征。实现类几乎总是可以提供更好的实现。
     * @return a {@code Spliterator} over the elements described by this 在这里描述的元素之上
     * {@code Iterable}.
     * @since 1.8
     */
    default Spliterator<T> spliterator() {
        return Spliterators.spliteratorUnknownSize(iterator(), 0);
    }
}
