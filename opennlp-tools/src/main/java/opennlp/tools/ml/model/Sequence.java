/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package opennlp.tools.ml.model;

/**
 * Class which models a sequence.
 * @param <T> The type of the object which is the source of this sequence.
 */
public class Sequence<T> {

  private final Event[] events;
  private final T source;

  /**
   * Initializes {@link Sequence} made up of the specified events and derived from the
   * specified source.
   *
   * @param events The {@link Event events} of the sequence.
   * @param source The {@link T source object} for this sequence.
   */
  public Sequence(Event[] events, T source) {
    this.events = events;
    this.source = source;
  }

  /**
   * @return Retrieves the events which make up this sequence.
   */
  public Event[] getEvents() {
    return events;
  }

  /**
   * This object is used when the events for this sequence need to be re-derived such
   * as in a call to {@link SequenceStream#updateContext(Sequence, AbstractModel)}.
   *
   * @return Retrieves an object from which this sequence can be derived.
   */
  public T getSource() {
    return source;
  }
}
