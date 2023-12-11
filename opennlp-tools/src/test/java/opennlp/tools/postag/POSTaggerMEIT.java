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

package opennlp.tools.postag;

import java.io.IOException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import opennlp.tools.postag.POSTaggerME;
import opennlp.tools.postag.POSTagger;
import opennlp.tools.util.Sequence;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class POSTaggerMEIT {

  private static POSTaggerME tagger;


  @BeforeAll
  static void setup() throws IOException {
      POSModel model = new POSModel(new FileInputStream("path/to/your/model.bin"));
      tagger = new POSTaggerME(model);
  }

  @Test
  void testGetAllPosTagsThreadSafety() throws InterruptedException {
    executeConcurrent(() -> {
        String[] tags = tagger.getAllPosTags();
    });
  }

  @Test
  void testTagThreadSafety() throws InterruptedException {
      executeConcurrent(() -> {
          String[] sentence = {"This", "is", "a", "test"};
          String[] tags = tagger.tag(sentence);
      });
  }

  @Test
  void testTopKSequencesThreadSafety() throws InterruptedException {
      executeConcurrent(() -> {
          String[] sentence = {"This", "is", "a", "test"};
          Sequence[] sequences = tagger.topKSequences(sentence);
      });
  }

  @Test
  void testProbsThreadSafety() throws InterruptedException {
      executeConcurrent(() -> {
          double[] probs = tagger.probs();
      });
  }

  private void executeConcurrent(Runnable task) throws InterruptedException {
      int numberOfThreads = 10;
      Thread[] threads = new Thread[numberOfThreads];
      for (int i = 0; i < numberOfThreads; i++) {
          threads[i] = new Thread(task);
          threads[i].start();
      }
      for (int i = 0; i < numberOfThreads; i++) {
          threads[i].join();
      }
  }


  @Test
  void testPOSTagger() throws IOException {

    POSTagger tagger = new POSTaggerME("en");

    String[] tags = tagger.tag(new String[] {
        "The",
        "driver",
        "got",
        "badly",
        "injured",
        "."});

    Assertions.assertEquals(6, tags.length);
    Assertions.assertEquals("DT", tags[0]);
    Assertions.assertEquals("NN", tags[1]);
    Assertions.assertEquals("VBD", tags[2]);
    Assertions.assertEquals("RB", tags[3]);
    Assertions.assertEquals("VBN", tags[4]);
    Assertions.assertEquals(".", tags[5]);
  }

}
