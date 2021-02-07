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

import java.util.function.Predicate;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * The root interface in the <i>collection hierarchy</i>.  A collection
 * represents a group of objects, known as its <i>elements</i>.  Some
 * collections allow duplicate elements and others do not.  Some are ordered
 * and others unordered.  The JDK does not provide any <i>direct</i>
 * implementations of this interface: it provides implementations of more
 * specific subinterfaces like <tt>Set</tt> and <tt>List</tt>.  This interface
 * is typically used to pass collections around and manipulate them where
 * maximum generality is desired.
 *
 * <p><i>Bags</i> or <i>multisets</i> (unordered collections that may contain
 * duplicate elements) should implement this interface directly.
 *
 * <p>All general-purpose <tt>Collection</tt> implementation classes (which
 * typically implement <tt>Collection</tt> indirectly through one of its
 * subinterfaces) should provide two "standard" constructors: a void (no
 * arguments) constructor, which creates an empty collection, and a
 * constructor with a single argument of type <tt>Collection</tt>, which
 * creates a new collection with the same elements as its argument.  In
 * effect, the latter constructor allows the user to copy any collection,
 * producing an equivalent collection of the desired implementation type.
 * There is no way to enforce this convention (as interfaces cannot contain
 * constructors) but all of the general-purpose <tt>Collection</tt>
 * implementations in the Java platform libraries comply.
 *
 * <p>The "destructive" methods contained in this interface, that is, the
 * methods that modify the collection on which they operate, are specified to
 * throw <tt>UnsupportedOperationException</tt> if this collection does not
 * support the operation.  If this is the case, these methods may, but are not
 * required to, throw an <tt>UnsupportedOperationException</tt> if the
 * invocation would have no effect on the collection.  For example, invoking
 * the {@link #addAll(Collection)} method on an unmodifiable collection may,
 * but is not required to, throw the exception if the collection to be added
 * is empty.
 *
 * <p><a name="optional-restrictions">
 * Some collection implementations have restrictions on the elements that
 * they may contain.</a>  For example, some implementations prohibit null elements,
 * and some have restrictions on the types of their elements.  Attempting to
 * add an ineligible element throws an unchecked exception, typically
 * <tt>NullPointerException</tt> or <tt>ClassCastException</tt>.  Attempting
 * to query the presence of an ineligible element may throw an exception,
 * or it may simply return false; some implementations will exhibit the former
 * behavior and some will exhibit the latter.  More generally, attempting an
 * operation on an ineligible element whose completion would not result in
 * the insertion of an ineligible element into the collection may throw an
 * exception or it may succeed, at the option of the implementation.
 * Such exceptions are marked as "optional" in the specification for this
 * interface.
 *
 * <p>It is up to each collection to determine its own synchronization
 * policy.  In the absence of a stronger guarantee by the
 * implementation, undefined behavior may result from the invocation
 * of any method on a collection that is being mutated by another
 * thread; this includes direct invocations, passing the collection to
 * a method that might perform invocations, and using an existing
 * iterator to examine the collection.
 *
 * <p>Many methods in Collections Framework interfaces are defined in
 * terms of the {@link Object#equals(Object) equals} method.  For example,
 * the specification for the {@link #contains(Object) contains(Object o)}
 * method says: "returns <tt>true</tt> if and only if this collection
 * contains at least one element <tt>e</tt> such that
 * <tt>(o==null ? e==null : o.equals(e))</tt>."  This specification should
 * <i>not</i> be construed to imply that invoking <tt>Collection.contains</tt>
 * with a non-null argument <tt>o</tt> will cause <tt>o.equals(e)</tt> to be
 * invoked for any element <tt>e</tt>.  Implementations are free to implement
 * optimizations whereby the <tt>equals</tt> invocation is avoided, for
 * example, by first comparing the hash codes of the two elements.  (The
 * {@link Object#hashCode()} specification guarantees that two objects with
 * unequal hash codes cannot be equal.)  More generally, implementations of
 * the various Collections Framework interfaces are free to take advantage of
 * the specified behavior of underlying {@link Object} methods wherever the
 * implementor deems it appropriate.
 *
 * <p>Some collection operations which perform recursive traversal of the
 * collection may fail with an exception for self-referential instances where
 * the collection directly or indirectly contains itself. This includes the
 * {@code clone()}, {@code equals()}, {@code hashCode()} and {@code toString()}
 * methods. Implementations may optionally handle the self-referential scenario,
 * however most current implementations do not do so.
 *
 * <p>This interface is a member of the
 * <a href="{@docRoot}/../technotes/guides/collections/index.html">
 * Java Collections Framework</a>.
 *
 * @implSpec
 * The default method implementations (inherited or otherwise) do not apply any
 * synchronization protocol.  If a {@code Collection} implementation has a
 * specific synchronization protocol, then it must override default
 * implementations to apply that protocol.
 *
 * @param <E> the type of elements in this collection
 *
 * @author  Josh Bloch
 * @author  Neal Gafter
 * @see     Set
 * @see     List
 * @see     Map
 * @see     SortedSet
 * @see     SortedMap
 * @see     HashSet
 * @see     TreeSet
 * @see     ArrayList
 * @see     LinkedList
 * @see     Vector
 * @see     Collections
 * @see     Arrays
 * @see     AbstractCollection
 * @since 1.2
 */

public interface Collection<E> extends Iterable<E> {
    // Query Operations

    /**
     * Returns the number of elements in this collection.  If this collection
     * contains more than <tt>Integer.MAX_VALUE</tt> elements, returns
     * <tt>Integer.MAX_VALUE</tt>.
     * 返回此集合中元素的数量。如果该集合包含超过<tt>Integer.MAX_VALUE</tt>元素，返回<tt>Integer.MAX_VALUE</tt>。
     * @return the number of elements in this collection 此集合中元素的数量
     */
    int size();

    /**
     * Returns <tt>true</tt> if this collection contains no elements.
     * 返回true如果该集合不包含元素。
     * @return <tt>true</tt> if this collection contains no elements
     */
    boolean isEmpty();

    /**
     * Returns <tt>true</tt> if this collection contains the specified element.
     * More formally, returns <tt>true</tt> if and only if this collection
     * contains at least one element <tt>e</tt> such that
     * <tt>(o==null&nbsp;?&nbsp;e==null&nbsp;:&nbsp;o.equals(e))</tt>.
     * 如果集合中包含指定的元素，则返回<tt>true</tt>。更正式地说，返回<tt>true</tt>当且仅当该集合包含至少一个元素<tt>e</tt>
     * @param o element whose presence in this collection is to be tested 被测试在此集合中是否存在的元素
     * @return <tt>true</tt> if this collection contains the specified
     *         element 如果此集合包含指定的元素
     * @throws ClassCastException if the type of the specified element
     *         is incompatible with this collection 如果指定元素的类型与该集合不兼容
     *         (<a href="#optional-restrictions">optional</a>)
     * @throws NullPointerException if the specified element is null and this
     *         collection does not permit null elements 如果指定的元素为空，并且该集合不允许空元素
     *         (<a href="#optional-restrictions">optional</a>)
     */
    boolean contains(Object o);

    /**
     * Returns an iterator over the elements in this collection.  There are no
     * guarantees concerning the order in which the elements are returned
     * (unless this collection is an instance of some class that provides a
     * guarantee).
     * 返回该集合中元素的迭代器。不能保证元素返回的顺序(除非这个集合是提供了保证的某个类的实例)。
     * @return an <tt>Iterator</tt> over the elements in this collection 该集合中的元素
     */
    Iterator<E> iterator();

    /**
     * Returns an array containing all of the elements in this collection.
     * If this collection makes any guarantees as to what order its elements
     * are returned by its iterator, this method must return the elements in
     * the same order.
     * 返回包含此集合中所有元素的数组。如果该集合对其迭代器返回元素的顺序做出任何保证，则该方法必须以相同的顺序返回元素
     * <p>The returned array will be "safe" in that no references to it are
     * maintained by this collection.  (In other words, this method must
     * allocate a new array even if this collection is backed by an array).
     * The caller is thus free to modify the returned array.
     * 返回的数组将是“安全的”，因为该集合不维护对它的引用。(换句话说，即使这个集合有一个数组支持，这个方法也必须分配一个新数组)。因此，调用者可以自由地修改返回的数组。
     * <p>This method acts as bridge between array-based and collection-based
     * APIs.
     * 此方法充当基于数组的api和基于集合的api之间的桥梁。
     * @return an array containing all of the elements in this collection 包含此集合中所有元素的数组
     */
    Object[] toArray();

    /**
     * Returns an array containing all of the elements in this collection;
     * the runtime type of the returned array is that of the specified array.
     * If the collection fits in the specified array, it is returned therein.
     * Otherwise, a new array is allocated with the runtime type of the
     * specified array and the size of this collection.
     * 返回一个包含该集合中的所有元素的数组;返回的数组的运行时类型是指定数组的运行时类型。如果集合符合指定的数组，则在其中返回集合。否则，将使用指定数组的运行时类型和该集合的大小分配一个新数组。
     * <p>If this collection fits in the specified array with room to spare
     * (i.e., the array has more elements than this collection), the element
     * in the array immediately following the end of the collection is set to
     * <tt>null</tt>.  (This is useful in determining the length of this
     * collection <i>only</i> if the caller knows that this collection does
     * not contain any <tt>null</tt> elements.)
     * 如果这个集合在指定的数组中有多余的空间(例如，这个数组的元素比这个集合的多)，那么紧接在集合末尾的数组中的元素就被设置为null。(只有当调用者知道这个集合不包含任何null元素时，这在确定这个集合的长度时才有用。)
     * <p>If this collection makes any guarantees as to what order its elements
     * are returned by its iterator, this method must return the elements in
     * the same order.
     * 如果这个集合保证了它的迭代器返回元素的顺序，那么这个方法必须以相同的顺序返回元素。
     * <p>Like the {@link #toArray()} method, this method acts as bridge between
     * array-based and collection-based APIs.  Further, this method allows
     * precise control over the runtime type of the output array, and may,
     * under certain circumstances, be used to save allocation costs.
     * 像{@link #toArray()}方法一样，这个方法充当了基于数组和基于集合的api之间的桥梁。此外，这种方法允许对输出数组的运行时类型进行精确控制，并且在某些情况下，可以使用这种方法来节省分配成本。
     * <p>Suppose <tt>x</tt> is a collection known to contain only strings.
     * The following code can be used to dump the collection into a newly
     * allocated array of <tt>String</tt>:
     * 假设x是已知只包含字符串的集合。下面的代码可以用来将集合转储到一个新分配的String数组中
     * <pre>
     *     String[] y = x.toArray(new String[0]);</pre>
     *
     * Note that <tt>toArray(new Object[0])</tt> is identical in function to
     * <tt>toArray()</tt>. 注意toArray(Object[0])在函数上与toArray()相同。
     *
     * @param <T> the runtime type of the array to contain the collection 包含集合的数组的运行时类型
     * @param a the array into which the elements of this collection are to be
     *        stored, if it is big enough; otherwise, a new array of the same
     *        runtime type is allocated for this purpose. 如果集合的元素足够大，则该数组将存储在其中;否则，将为此目的分配一个相同运行时类型的新数组。
     * @return an array containing all of the elements in this collection 包含此集合中所有元素的数组
     * @throws ArrayStoreException if the runtime type of the specified array
     *         is not a supertype of the runtime type of every element in
     *         this collection 如果指定数组的运行时类型不是此集合中每个元素的运行时类型的超类型
     * @throws NullPointerException if the specified array is null 如果指定的数组为空
     */
    <T> T[] toArray(T[] a);

    // Modification Operations

    /**
     * Ensures that this collection contains the specified element (optional
     * operation).  Returns <tt>true</tt> if this collection changed as a
     * result of the call.  (Returns <tt>false</tt> if this collection does
     * not permit duplicates and already contains the specified element.)<p>
     * 确保此集合包含指定的元素(可选操作)。如果此集合因调用而更改，则返回true。(如果该集合不允许重复且已经包含指定元素，则返回false。
     * Collections that support this operation may place limitations on what
     * elements may be added to this collection.  In particular, some
     * collections will refuse to add <tt>null</tt> elements, and others will
     * impose restrictions on the type of elements that may be added.
     * Collection classes should clearly specify in their documentation any
     * restrictions on what elements may be added.<p>
     * 支持此操作的集合可能会限制向该集合添加的元素。特别是，一些集合将拒绝添加<tt>null</tt>元素，而其他集合将对可能添加的元素类型施加限制。集合类应该在其文档中清楚地指定任何可以添加的元素的限制
     * If a collection refuses to add a particular element for any reason
     * other than that it already contains the element, it <i>must</i> throw
     * an exception (rather than returning <tt>false</tt>).  This preserves
     * the invariant that a collection always contains the specified element
     * after this call returns.
     * 如果一个集合因为任何原因拒绝添加特定元素，而不是因为它已经包含了某个元素，则<i>必须</i>抛出异常(而不是返回<tt>false</tt>)。这保留了调用返回后集合始终包含指定元素的不变式。
     * @param e element whose presence in this collection is to be ensured 必须确保其存在于此集合中的组件
     * @return <tt>true</tt> if this collection changed as a result of the
     *         call
     * @throws UnsupportedOperationException if the <tt>add</tt> operation
     *         is not supported by this collection 如果这个集合不支持<tt>add</tt>操作
     * @throws ClassCastException if the class of the specified element
     *         prevents it from being added to this collection 如果指定元素的类阻止将其添加到此集合
     * @throws NullPointerException if the specified element is null and this
     *         collection does not permit null elements 如果指定的元素为空，并且该集合不允许空元素
     * @throws IllegalArgumentException if some property of the element
     *         prevents it from being added to this collection 如果元素的某些属性阻止将其添加到此集合
     * @throws IllegalStateException if the element cannot be added at this
     *         time due to insertion restrictions 如果由于插入限制，此时无法添加元素
     */
    boolean add(E e);

    /**
     * Removes a single instance of the specified element from this
     * collection, if it is present (optional operation).  More formally,
     * removes an element <tt>e</tt> such that
     * <tt>(o==null&nbsp;?&nbsp;e==null&nbsp;:&nbsp;o.equals(e))</tt>, if
     * this collection contains one or more such elements.  Returns
     * <tt>true</tt> if this collection contained the specified element (or
     * equivalently, if this collection changed as a result of the call).
     * 从集合中删除指定元素的单个实例(如果存在的话)(可选操作)。更正式的做法是，如果集合中包含一个或多个这样的元素，则删除这样的元素e (o==null?e==null:o.equals(e))。如果该集合包含指定的元素(或等效地，如果该集合因调用而更改)，则返回true。
     * @param o element to be removed from this collection, if present 如果存在，则元素将被从该集合中删除
     * @return <tt>true</tt> if an element was removed as a result of this call 如果由于这个调用而删除了一个元素
     * @throws ClassCastException if the type of the specified element
     *         is incompatible with this collection 如果指定元素的类型与该集合不兼容
     *         (<a href="#optional-restrictions">optional</a>)
     * @throws NullPointerException if the specified element is null and this
     *         collection does not permit null elements 如果指定的元素为空，并且该集合不允许空元素
     *         (<a href="#optional-restrictions">optional</a>)
     * @throws UnsupportedOperationException if the <tt>remove</tt> operation
     *         is not supported by this collection 如果这个集合不支持<tt>remove</tt>操作
     */
    boolean remove(Object o);


    // Bulk Operations

    /**
     * Returns <tt>true</tt> if this collection contains all of the elements
     * in the specified collection.
     * 如果集合包含指定集合中的所有元素，则返回<tt>true</tt>。
     * @param  c collection to be checked for containment in this collection 要检查的集合中是否包含此集合
     * @return <tt>true</tt> if this collection contains all of the elements
     *         in the specified collection 如果此集合包含指定集合中的所有元素
     * @throws ClassCastException if the types of one or more elements
     *         in the specified collection are incompatible with this
     *         collection 如果指定集合中的一个或多个元素的类型与此集合不兼容
     *         (<a href="#optional-restrictions">optional</a>)
     * @throws NullPointerException if the specified collection contains one
     *         or more null elements and this collection does not permit null
     *         elements 如果指定的集合包含一个或多个空元素，而该集合不允许空元素
     *         (<a href="#optional-restrictions">optional</a>),
     *         or if the specified collection is null. 或者指定的集合为空。
     * @see    #contains(Object)
     */
    boolean containsAll(Collection<?> c);

    /**
     * Adds all of the elements in the specified collection to this collection
     * (optional operation).  The behavior of this operation is undefined if
     * the specified collection is modified while the operation is in progress.
     * (This implies that the behavior of this call is undefined if the
     * specified collection is this collection, and this collection is
     * nonempty.)
     * 将指定集合中的所有元素添加到此集合(可选操作)。如果在操作进行中修改了指定的集合，则此操作的行为未定义。(这意味着，如果指定的集合是这个集合，并且这个集合是非空的，那么这个调用的行为是未定义的。)
     * @param c collection containing elements to be added to this collection 包含要添加到此集合的元素的集合
     * @return <tt>true</tt> if this collection changed as a result of the call 如果此集合因调用而更改
     * @throws UnsupportedOperationException if the <tt>addAll</tt> operation
     *         is not supported by this collection 如果<tt>addAll</tt>操作不被这个集合支持
     * @throws ClassCastException if the class of an element of the specified
     *         collection prevents it from being added to this collection 如果指定集合的元素的类阻止将其添加到此集合
     * @throws NullPointerException if the specified collection contains a
     *         null element and this collection does not permit null elements,
     *         or if the specified collection is null 如果指定的集合包含空元素而该集合不允许空元素，或者指定的集合为空
     * @throws IllegalArgumentException if some property of an element of the
     *         specified collection prevents it from being added to this
     *         collection 如果指定集合的某个元素的某些属性阻止将其添加到此集合
     * @throws IllegalStateException if not all the elements can be added at
     *         this time due to insertion restrictions 如果由于插入限制不是在同一时间完成所有元素的插入
     * @see #add(Object)
     */
    boolean addAll(Collection<? extends E> c);

    /**
     * Removes all of this collection's elements that are also contained in the
     * specified collection (optional operation).  After this call returns,
     * this collection will contain no elements in common with the specified
     * collection.
     * 删除指定集合中包含的该集合的所有元素(可选操作)。此调用返回后，此集合将不包含与指定集合相同的元素。
     * @param c collection containing elements to be removed from this collection 包含要从该集合中删除的元素的集合
     * @return <tt>true</tt> if this collection changed as a result of the
     *         call 如果此集合因调用而更改
     * @throws UnsupportedOperationException if the <tt>removeAll</tt> method
     *         is not supported by this collection 如果<tt>removeAll</tt>方法不被这个集合支持
     * @throws ClassCastException if the types of one or more elements
     *         in this collection are incompatible with the specified
     *         collection 如果此集合中的一个或多个元素的类型与指定的集合不兼容
     *         (<a href="#optional-restrictions">optional</a>)
     * @throws NullPointerException if this collection contains one or more
     *         null elements and the specified collection does not support
     *         null elements 如果这个集合包含一个或多个null元素，并且指定的集合不支持null元素（可选的）
     *         (<a href="#optional-restrictions">optional</a>),
     *         or if the specified collection is null 或者指定的集合为null
     * @see #remove(Object)
     * @see #contains(Object)
     */
    boolean removeAll(Collection<?> c);

    /**
     * Removes all of the elements of this collection that satisfy the given
     * predicate.  Errors or runtime exceptions thrown during iteration or by
     * the predicate are relayed to the caller.
     * 删除该集合中满足给定谓词的所有元素。迭代期间或由谓词抛出的错误或运行时异常被转发给调用者。
     * @implSpec
     * The default implementation traverses all elements of the collection using
     * its {@link #iterator}.  Each matching element is removed using
     * {@link Iterator#remove()}.  If the collection's iterator does not
     * support removal then an {@code UnsupportedOperationException} will be
     * thrown on the first matching element.
     * 默认实现使用its{@link #iterator}遍历集合的所有元素。使用{@link Iterator#remove()}删除每个匹配的元素。如果集合的迭代器不支持删除，那么第一个匹配的元素将抛出{@code UnsupportedOperationException}。
     * @param filter a predicate which returns {@code true} for elements to be
     *        removed 对于要删除的元素，返回{@code true}的谓词
     * @return {@code true} if any elements were removed 如果移除任何元素
     * @throws NullPointerException if the specified filter is null 如果指定的过滤器为空
     * @throws UnsupportedOperationException if elements cannot be removed
     *         from this collection.  Implementations may throw this exception if a
     *         matching element cannot be removed or if, in general, removal is not
     *         supported. 如果无法从该集合中删除元素。如果不能删除匹配的元素，或者通常不支持删除，则实现可能抛出此异常。
     * @since 1.8
     */
    default boolean removeIf(Predicate<? super E> filter) {
        Objects.requireNonNull(filter);
        boolean removed = false;
        final Iterator<E> each = iterator();
        while (each.hasNext()) {
            if (filter.test(each.next())) {
                each.remove();
                removed = true;
            }
        }
        return removed;
    }

    /**
     * Retains only the elements in this collection that are contained in the
     * specified collection (optional operation).  In other words, removes from
     * this collection all of its elements that are not contained in the
     * specified collection.
     * 只保留该集合中包含在指定集合中的元素(可选操作)。换句话说，从该集合中删除指定集合中不包含的所有元素。
     * @param c collection containing elements to be retained in this collection 包含要在此集合中保留的元素的集合
     * @return <tt>true</tt> if this collection changed as a result of the call 如果此集合因调用而更改
     * @throws UnsupportedOperationException if the <tt>retainAll</tt> operation
     *         is not supported by this collection 如果<tt>retainAll</tt>操作不被这个集合支持
     * @throws ClassCastException if the types of one or more elements
     *         in this collection are incompatible with the specified
     *         collection 如果此集合中的一个或多个元素的类型与指定的集合不兼容
     *         (<a href="#optional-restrictions">optional</a>)
     * @throws NullPointerException if this collection contains one or more
     *         null elements and the specified collection does not permit null
     *         elements
     *         (<a href="#optional-restrictions">optional</a>),
     *         or if the specified collection is null
     * @see #remove(Object)
     * @see #contains(Object)
     */
    boolean retainAll(Collection<?> c);

    /**
     * Removes all of the elements from this collection (optional operation).
     * The collection will be empty after this method returns.
     * 从集合中删除所有元素(可选操作)。此方法返回后，集合将为空。
     * @throws UnsupportedOperationException if the <tt>clear</tt> operation
     *         is not supported by this collection
     */
    void clear();


    // Comparison and hashing

    /**
     * Compares the specified object with this collection for equality. <p>
     * 比较指定的对象与此集合是否相等
     * While the <tt>Collection</tt> interface adds no stipulations to the
     * general contract for the <tt>Object.equals</tt>, programmers who
     * implement the <tt>Collection</tt> interface "directly" (in other words,
     * create a class that is a <tt>Collection</tt> but is not a <tt>Set</tt>
     * or a <tt>List</tt>) must exercise care if they choose to override the
     * <tt>Object.equals</tt>.  It is not necessary to do so, and the simplest
     * course of action is to rely on <tt>Object</tt>'s implementation, but
     * the implementor may wish to implement a "value comparison" in place of
     * the default "reference comparison."  (The <tt>List</tt> and
     * <tt>Set</tt> interfaces mandate such value comparisons.)<p>
     * 而收集接口没有向对象的一般契约添加规定。如果选择重写Object.equals，“直接”实现集合接口(换句话说，创建的类是集合，而不是集合或列表)的程序员必须小心谨慎。没有必要这样做，最简单的做法是依赖于Object的实现，但实现者可能希望实现一个“值比较”来代替默认的“引用比较”。(List和Set接口要求进行这种值比较。)
     * The general contract for the <tt>Object.equals</tt> method states that
     * equals must be symmetric (in other words, <tt>a.equals(b)</tt> if and
     * only if <tt>b.equals(a)</tt>).  The contracts for <tt>List.equals</tt>
     * and <tt>Set.equals</tt> state that lists are only equal to other lists,
     * and sets to other sets.  Thus, a custom <tt>equals</tt> method for a
     * collection class that implements neither the <tt>List</tt> nor
     * <tt>Set</tt> interface must return <tt>false</tt> when this collection
     * is compared to any list or set.  (By the same logic, it is not possible
     * to write a class that correctly implements both the <tt>Set</tt> and
     * <tt>List</tt> interfaces.)
     * (Object.equals)方法的一般契约规定等号必须是对称的(换句话说，a.equals(b)当且仅当b.equals(a))。合同的清单。equals和Set.equals表示列表只与其他列表相等，而集合只与其他集合相等。因此,自定义等于一个集合类实现方法列表和设置界面必须返回假当这个集合是任何列表或组相比。(同样的逻辑,它是不可能正确地编写一个类,实现了集和列表界面。)
     * @param o object to be compared for equality with this collection 比较是否与此集合相等的对象
     * @return <tt>true</tt> if the specified object is equal to this
     * collection 如果指定的对象等于此集合
     *
     * @see Object#equals(Object)
     * @see Set#equals(Object)
     * @see List#equals(Object)
     */
    boolean equals(Object o);

    /**
     * Returns the hash code value for this collection.  While the
     * <tt>Collection</tt> interface adds no stipulations to the general
     * contract for the <tt>Object.hashCode</tt> method, programmers should
     * take note that any class that overrides the <tt>Object.equals</tt>
     * method must also override the <tt>Object.hashCode</tt> method in order
     * to satisfy the general contract for the <tt>Object.hashCode</tt> method.
     * In particular, <tt>c1.equals(c2)</tt> implies that
     * <tt>c1.hashCode()==c2.hashCode()</tt>.
     * 返回此集合的哈希码值。而收集接口添加的总承包合同没有规定(Object.hashCode)方法,程序员应该注意,任何类,覆盖(Object.equals)方法也必须覆盖(Object.hashCode)方法以满足一般合同(Object.hashCode)方法。特别地，c1.equals(c2)意味着c1.hashCode()==c2. hashcode()。
     * @return the hash code value for this collection 此集合的哈希码值
     *
     * @see Object#hashCode()
     * @see Object#equals(Object)
     */
    int hashCode();

    /**
     * Creates a {@link Spliterator} over the elements in this collection.
     *
     * Implementations should document characteristic values reported by the
     * spliterator.  Such characteristic values are not required to be reported
     * if the spliterator reports {@link Spliterator#SIZED} and this collection
     * contains no elements.
     *
     * <p>The default implementation should be overridden by subclasses that
     * can return a more efficient spliterator.  In order to
     * preserve expected laziness behavior for the {@link #stream()} and
     * {@link #parallelStream()}} methods, spliterators should either have the
     * characteristic of {@code IMMUTABLE} or {@code CONCURRENT}, or be
     * <em><a href="Spliterator.html#binding">late-binding</a></em>.
     * If none of these is practical, the overriding class should describe the
     * spliterator's documented policy of binding and structural interference,
     * and should override the {@link #stream()} and {@link #parallelStream()}
     * methods to create streams using a {@code Supplier} of the spliterator,
     * as in:
     * <pre>{@code
     *     Stream<E> s = StreamSupport.stream(() -> spliterator(), spliteratorCharacteristics)
     * }</pre>
     * <p>These requirements ensure that streams produced by the
     * {@link #stream()} and {@link #parallelStream()} methods will reflect the
     * contents of the collection as of initiation of the terminal stream
     * operation.
     *
     * @implSpec
     * The default implementation creates a
     * <em><a href="Spliterator.html#binding">late-binding</a></em> spliterator
     * from the collections's {@code Iterator}.  The spliterator inherits the
     * <em>fail-fast</em> properties of the collection's iterator.
     * <p>
     * The created {@code Spliterator} reports {@link Spliterator#SIZED}.
     *
     * @implNote
     * The created {@code Spliterator} additionally reports
     * {@link Spliterator#SUBSIZED}.
     *
     * <p>If a spliterator covers no elements then the reporting of additional
     * characteristic values, beyond that of {@code SIZED} and {@code SUBSIZED},
     * does not aid clients to control, specialize or simplify computation.
     * However, this does enable shared use of an immutable and empty
     * spliterator instance (see {@link Spliterators#emptySpliterator()}) for
     * empty collections, and enables clients to determine if such a spliterator
     * covers no elements.
     *
     * @return a {@code Spliterator} over the elements in this collection
     * @since 1.8
     */
    @Override
    default Spliterator<E> spliterator() {
        return Spliterators.spliterator(this, 0);
    }

    /**
     * Returns a sequential {@code Stream} with this collection as its source.
     * 返回一个顺序的{@code Stream}，该集合作为其源。
     * <p>This method should be overridden when the {@link #spliterator()}
     * method cannot return a spliterator that is {@code IMMUTABLE},
     * {@code CONCURRENT}, or <em>late-binding</em>. (See {@link #spliterator()}
     * for details.)
     * 当{@link #spliterator()}方法不能返回{@code IMMUTABLE}、{@code CONCURRENT}或<em>后期绑定</em>时，这个方法应该被重写。(详见{@link #spliterator()})
     * @implSpec
     * The default implementation creates a sequential {@code Stream} from the
     * collection's {@code Spliterator}.
     * 默认实现从集合的{@code Spliterator}中创建一个连续的{@code Stream}。
     * @return a sequential {@code Stream} over the elements in this collection 该集合中的元素上的序列{@code Stream}
     * @since 1.8
     */
    default Stream<E> stream() {
        return StreamSupport.stream(spliterator(), false);
    }

    /**
     * Returns a possibly parallel {@code Stream} with this collection as its
     * source.  It is allowable for this method to return a sequential stream.
     * 返回一个可能并行的{@code流}，该集合作为其源。允许此方法返回一个顺序流。
     * <p>This method should be overridden when the {@link #spliterator()}
     * method cannot return a spliterator that is {@code IMMUTABLE},
     * {@code CONCURRENT}, or <em>late-binding</em>. (See {@link #spliterator()}
     * for details.)
     * 当{@link #spliterator()}方法不能返回{@code IMMUTABLE}、{@code CONCURRENT}或<em>后期绑定</em>时，这个方法应该被重写。(详见{@link #spliterator()})
     * @implSpec
     * The default implementation creates a parallel {@code Stream} from the
     * collection's {@code Spliterator}.
     * 默认实现从集合的{@code拆分器}中创建一个并行的{@code流}。
     * @return a possibly parallel {@code Stream} over the elements in this
     * collection 一个可能并行的{@code流}在这个集合中的元素之上
     * @since 1.8
     */
    default Stream<E> parallelStream() {
        return StreamSupport.stream(spliterator(), true);
    }
}
