/*
 * Copyright 2013 kwart, betterphp, nviennot
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package jd.core.input;

import jd.core.output.JDOutput;
import jd.ide.intellij.JavaDecompiler;

/**
 * {@link JDInput} implementation which takes a single class file as an input.
 * 
 * @author Josef Cacek
 */
public class ClassFileInput extends AbstractFileJDInput {

    public ClassFileInput(String path) {
        super(path);
    }

    /*
     * (non-Javadoc)
     * 
     * @see jd.core.input.JDInput#decompile(jd.ide.intellij.JavaDecompiler, jd.core.output.JDOutput)
     */
    @Override
    public void decompile(JavaDecompiler javaDecompiler, JDOutput jdOutput) {
        if (javaDecompiler == null || jdOutput == null) {
            return;
        }

        jdOutput.init("");
        final String name = file.getName();
        jdOutput.processClass(cutClassSuffix(name), javaDecompiler.decompileClass(file.getAbsoluteFile().getParent(), name));
        jdOutput.commit();
    }
}