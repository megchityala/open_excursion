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

package opennlp.tools.formats.convert;

import opennlp.tools.commons.Internal;
import opennlp.tools.namefind.NameSample;
import opennlp.tools.tokenize.Detokenizer;
import opennlp.tools.util.ObjectStream;

/**
 * <b>Note:</b>
 * Do not use this class, internal use only!
 */
@Internal
public class NameToSentenceSampleStream extends AbstractToSentenceSampleStream<NameSample> {

  /**
   * Initializes a {@link NameToSentenceSampleStream}.
   *
   * @param detokenizer The {@link Detokenizer} to use. Must not be {@code null}.
   * @param samples The {@link ObjectStream<NameSample> samples} as input. Must not be {@code null}.
   * @param chunkSize The size of chunks. Must be equal to or greater than {@code 0}.
   *
   * @throws IllegalArgumentException Thrown if parameters are invalid.
   */
  public NameToSentenceSampleStream(Detokenizer detokenizer,
      ObjectStream<NameSample> samples, int chunkSize) {
    super(detokenizer, samples, chunkSize);
  }

  @Override
  protected String[] toSentence(NameSample sample) {
    return sample.getSentence();
  }
}
