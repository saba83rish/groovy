/*
 * Copyright 2003-2007 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.codehaus.groovy.runtime;

import groovy.lang.MetaMethod;
import groovy.lang.MissingMethodException;



/**
 * Provides as alternative to reflection using bytecode generation.
 * 
 * @author <a href="mailto:james@coredevelopers.net">James Strachan</a>
 * @version $Revision: 4247 $
 */
public class Reflector {

    public Object invoke(MetaMethod method, Object object, Object[] arguments) {
        return noSuchMethod(method, object, arguments);
    }

    protected Object noSuchMethod(MetaMethod method, Object object, Object[] arguments) {
        throw new MissingMethodException(method.getName(), method.getDeclaringClass().cachedClass, arguments, false);
    }
}
