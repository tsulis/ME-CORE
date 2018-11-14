/*
 * Copyright 2014-2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.me.core.libraries.wrapper;

import java.util.List;
import java.util.function.Function;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.util.Streamable;

/**
 * A slice of data that indicates whether there's a next or previous slice available. Allows to obtain a
 * {@link Pageable} to request a previous or next {@link SliceWrapper}.
 *
 * @author Oliver Gierke
 * @since 1.8
 */
public interface SliceWrapper<T> extends Streamable<T> {

	/**
	 * Returns the number of the current {@link SliceWrapper}. Is always non-negative.
	 *
	 * @return the number of the current {@link SliceWrapper}.
	 */
	int getNumber();

	/**
	 * Returns the size of the {@link SliceWrapper}.
	 *
	 * @return the size of the {@link SliceWrapper}.
	 */
	int getSize();

	/**
	 * Returns the number of elements currently on this {@link SliceWrapper}.
	 *
	 * @return the number of elements currently on this {@link SliceWrapper}.
	 */
	int getNumberOfElements();

	/**
	 * Returns the page content as {@link List}.
	 *
	 * @return List of class
	 */
	List<T> getContent();

	/**
	 * Returns whether the {@link SliceWrapper} has content at all.
	 *
	 * @return true or false
	 */
	boolean hasContent();

	/**
	 * Returns the sorting parameters for the {@link SliceWrapper}.
	 *
	 * @return Class of Sort
	 */
	Sort getSort();

	/**
	 * Returns whether the current {@link SliceWrapper} is the first one.
	 *
	 * @return true or false
	 */
	boolean isFirst();

	/**
	 * Returns whether the current {@link SliceWrapper} is the last one.
	 *
	 * @return true or false
	 */
	boolean isLast();

	/**
	 * Returns if there is a next {@link SliceWrapper}.
	 *
	 * @return if there is a next {@link SliceWrapper}.
	 */
	boolean hasNext();

	/**
	 * Returns if there is a previous {@link SliceWrapper}.
	 *
	 * @return if there is a previous {@link SliceWrapper}.
	 */
	boolean hasPrevious();

	/**
	 * Returns the {@link Pageable} that's been used to request the current {@link SliceWrapper}.
	 *
	 * @return instance Class
	 * @since 2.0
	 */
	default Pageable getPageable() {
		return PageRequest.of(getNumber(), getSize(), getSort());
	}

	/**
	 * Returns the {@link Pageable} to request the next {@link SliceWrapper}. Can be {@literal null} in case the current
	 * {@link SliceWrapper} is already the last one. Clients should check {@link #hasNext()} before calling this method to make
	 * sure they receive a non-{@literal null} value.
	 *
	 * @return Class
	 */
	Pageable nextPageable();

	/**
	 * Returns the {@link Pageable} to request the previous {@link SliceWrapper}. Can be {@literal null} in case the current
	 * {@link SliceWrapper} is already the first one. Clients should check {@link #hasPrevious()} before calling this method make
	 * sure receive a non-{@literal null} value.
	 *
	 * @return Class
	 */
	Pageable previousPageable();

	/**
	 * Returns a new {@link SliceWrapper} with the content of the current one mapped by the given {@link Converter}.
	 *
	 * @param converter must not be {@literal null}.
	 * @return a new {@link SliceWrapper} with the content of the current one mapped by the given {@link Converter}.
	 * @since 1.10
	 */
	<U> SliceWrapper<U> map(Function<? super T, ? extends U> converter);
}
