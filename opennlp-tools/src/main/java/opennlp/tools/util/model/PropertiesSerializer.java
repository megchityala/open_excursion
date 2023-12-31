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


package opennlp.tools.util.model;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;
import java.util.Properties;

/**
 * An {@link ArtifactSerializer} implementation for {@link Properties properties}.
 */
class PropertiesSerializer implements ArtifactSerializer<Properties> {

  @Override
  public Properties create(InputStream in) throws IOException {
    Properties properties = new Properties();
    properties.load(in);
    return properties;
  }

  @Override
  public void serialize(Properties properties, OutputStream out) throws IOException {
    properties.store(out, "");
  }

  /**
   * Registers a new {@link PropertiesSerializer} in the given {@code factories} mapping.
   *
   * @param factories A {@link Map} holding {@link ArtifactSerializer} for re-use.
   */
  static void register(Map<String, ArtifactSerializer<?>> factories) {
    factories.put("properties", new PropertiesSerializer());
  }
}
