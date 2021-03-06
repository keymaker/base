/*
 * Copyright 2009 The Fornax Project Team, including the original 
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
package org.fornax.cartridges.sculptor.framework.richclient.databinding;

import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.fornax.cartridges.sculptor.framework.richclient.SculptorFrameworkPlugin;

/**
 * Checks if length of String is less than or equal to a max length.
 *
 */
public class StringMaxLengthValidator implements IValidator {

    private String message;
    private int severity;
    private int maxLength;

    public StringMaxLengthValidator(int maxLength, String message) {
        this(maxLength, message, IStatus.ERROR);
    }
    
    public StringMaxLengthValidator(int maxLength, String message, int severity) {
        this.maxLength = maxLength;
        this.message = message;
        this.severity = severity;
    }

    
    public IStatus validate(Object value) {
        if (value != null && (value instanceof String && ((String) value).length() > maxLength)) {
            return new Status(severity, SculptorFrameworkPlugin.PLUGIN_ID, message);
        }
        
        return Status.OK_STATUS;
    }
}
