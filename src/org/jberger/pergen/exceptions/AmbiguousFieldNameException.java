/* Copyright 2007 Jacques Berger

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
*/

package org.jberger.pergen.exceptions;

/**
 * Raised when two entities produces the same name after a
 * transformation.
 */
public class AmbiguousFieldNameException extends RuntimeException {

    public AmbiguousFieldNameException(final String firstFieldName,
                                       final String secondFieldName,
                                       final String entityName,
                                       final String resultingName) {
        super("The two fields " + firstFieldName + " and " + secondFieldName
              + " in entity " + entityName + " produces the same name: "
              + resultingName + ".");
    }
}
