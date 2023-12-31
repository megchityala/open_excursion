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

package opennlp.tools.cmdline;

/**
 * Base class for tools which take additional parameters. For example, trainers or evaluators.
 */
public abstract class AbstractTypedParamTool<T, P> extends TypedCmdLineTool<T, P> {

  /**
   * variable to access the parameters
   */
  protected final Class<P> paramsClass;

  /**
   * Constructor with type parameters.
   *
   * @param sampleType class of the template parameter
   * @param paramsClass interface with parameters
   */
  protected AbstractTypedParamTool(Class<T> sampleType, Class<P> paramsClass) {
    super(sampleType);
    this.paramsClass = paramsClass;
  }

  @Override
  public String getHelp(String format) {
    if ("".equals(format) || StreamFactoryRegistry.DEFAULT_FORMAT.equals(format)) {
      return getBasicHelp(paramsClass,
          StreamFactoryRegistry.getFactory(type, StreamFactoryRegistry.DEFAULT_FORMAT).getParameters());
    } else {
      ObjectStreamFactory<T,P> factory = StreamFactoryRegistry.getFactory(type, format);
      if (null == factory) {
        throw new TerminateToolException(1, "Format " + format + " is not found.\n" + getHelp());
      }
      return "Usage: " + CLI.CMD + " " + getName() + "." + format + " " +
          ArgumentParser.createUsage(paramsClass, factory.getParameters());
    }
  }
}
