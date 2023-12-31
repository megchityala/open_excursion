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

package opennlp.tools.cmdline.params;

import opennlp.tools.cmdline.ArgumentParser.OptionalParameter;
import opennlp.tools.cmdline.ArgumentParser.ParameterDescription;
import opennlp.tools.commons.Internal;

/**
 * Common cross validator parameters.
 * <p>
 * <b>Note:</b> Do not use this class, internal use only!
 */
@Internal
public interface CVParams {

  @ParameterDescription(valueName = "true|false",
      description = "if true will print false negatives and false positives.")
  @OptionalParameter(defaultValue = "false")
  Boolean getMisclassified();

  @ParameterDescription(valueName = "num", description = "number of folds, default is 10.")
  @OptionalParameter(defaultValue = "10")
  Integer getFolds();

}
