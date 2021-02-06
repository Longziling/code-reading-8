/*
 * Copyright (c) 1997, 2013, Oracle and/or its affiliates. All rights reserved.
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

import java.util.function.Consumer;

/**
 * An iterator over a collection.  {@code Iterator} takes the place of
 * {@link Enumeration} in the Java Collections Framework.  Iterators
 * differ from enumerations in two ways:
 * 集合上的迭代器。在Java集合框架中，{@code Iterator}代替了{@link Enumeration}。迭代器与枚举器有两个不同之处
 * <ul>
 *      <li> Iterators allow the caller to remove elements from the
 *           underlying collection during the iteration with well-defined
 *           semantics. 迭代器允许调用者在迭代期间使用定义良好的语义从基础集合中删除元素。
 *      <li> Method names have been improved. 方法名得到了改进。
 * </ul>
 *
 * <p>This interface is a member of the
 * <a href="{@docRoot}/../technotes/guides/collections/index.html">
 * Java Collections Framework</a>.
 *
 * @param <E> the type of elements returned by this iterator
 * 此迭代器返回的元素类型
 * @author  Josh Bloch
 * @see Collection
 * @see ListIterator
 * @see Iterable
 * @since 1.2
 */
public interface Iterator<E> {
    /**
     * Returns {@code true} if the iteration has more elements.
     * (In other words, returns {@code true} if {@link #next} would
     * return an element rather than throwing an exception.)
     * 如果迭代有更多的元素，返回{@code true}。(换句话说，如果{@link #next}返回一个元素而不是抛出异常，则返回{@code true}。)
     * @return {@code true} if the iteration has more elements 如果迭代有更多的元素
     */
    boolean hasNext();

    /**
     * Returns the next element in the iteration.
     * 返回迭代中的下一个元素。
     * @return the next element in the iteration
     * @throws NoSuchElementException if the iteration has no more elements 如果迭代没有更多的元素
     */
    E next();

    /**
     * Removes from the underlying collection the last element returned
     * by this iterator (optional operation).  This method can be called
     * only once per call to {@link #next}.  The behavior of an iterator
     * is unspecified if the underlying collection is modified while the
     * iteration is in progress in any way other than by calling this
     * method.
     * 从基础集合中移除该迭代器返回的最后一个元素(可选操作)。这个方法在每次调用{@link #next}时只能被调用一次。如果在迭代进行过程中底层集合被修改，则迭代器的行为是未指定的，除非调用此方法。
     * @implSpec
     * The default implementation throws an instance of
     * {@link UnsupportedOperationException} and performs no other action.
     * 默认实现抛出一个{@link UnsupportedOperationException}的实例，并且不执行其他操作
     * @throws UnsupportedOperationException if the {@code remove}
     *         operation is not supported by this iterator
     * 如果这个迭代器不支持{@code remove}操作
     * @throws IllegalStateException if the {@code next} method has not
     *         yet been called, or the {@code remove} method has already
     *         been called after the last call to the {@code next}
     *         method 如果{@code next}方法还没有被调用，或者在最后一次调用{@code next}方法之后已经调用了{@code remove}方法
     */
    default void remove() {
        throw new UnsupportedOperationException("remove");
    }

    /**
     * Performs the given action for each remaining element until all elements
     * have been processed or the action throws an exception.  Actions are
     * performed in the order of iteration, if that order is specified.
     * Exceptions thrown by the action are relayed to the caller.
     * 对剩余的每个元素执行给定的操作，直到处理完所有元素或该操作抛出异常。如果指定了迭代的顺序，则按照迭代的顺序执行操作。动作抛出的异常被转发给调用者。
     * @implSpec
     * <p>The default implementation behaves as if: 默认的实现行为如下:
     * <pre>{@code
     *     while (hasNext())
     *         action.accept(next());
     * }</pre>
     *
     * @param action The action to be performed for each element 要对每个元素执行的操作
     * @throws NullPointerException if the specified action is null 如果指定的动作为空
     * @since 1.8
     */
    default void forEachRemaining(Consumer<? super E> action) {
        Objects.requireNonNull(action);
        while (hasNext())
            action.accept(next());
    }
}
