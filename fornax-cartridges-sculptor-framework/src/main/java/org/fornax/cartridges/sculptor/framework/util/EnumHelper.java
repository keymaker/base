/*
 * Copyright 2007 The Fornax Project Team, including the original
 * author or authors.
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

package org.fornax.cartridges.sculptor.framework.util;

import java.lang.reflect.Method;

public class EnumHelper {

    @SuppressWarnings("unchecked")
    public static Enum toEnum(Class enumClass, Object value) {
        assert enumClass != null;
        if (value == null) {
            return null;
        }
        try {
            Method method = enumClass.getMethod("toEnum", Object.class);
            return (Enum) method.invoke(null, value);
        } catch (Exception e) {
            throw new IllegalArgumentException("value " + value + " can not be converted to Enum '" + enumClass.getSimpleName() + "'" , e);
        }
    }

    public static Object toData(Enum<?> enumClass) {
        if (enumClass == null) {
            return null;
        }
        try {
            Method method = enumClass.getClass().getMethod("toData");
            return method.invoke(enumClass);
        } catch (Exception e) {
            throw new IllegalArgumentException("Enum '" + enumClass.getClass().getSimpleName() + "' can not be converted to value", e);
        }
    }

}
