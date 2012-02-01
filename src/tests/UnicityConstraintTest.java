/* Copyright 2011 Jacques Berger

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

package tests;

import java.util.Collection;

import junit.framework.TestCase;

import org.junit.Test;

import domain.FieldInformations;
import domain.FieldType;
import domain.UnicityConstraint;

public class UnicityConstraintTest extends TestCase {

    @Test
    public void testUnicityConstraint() {
	UnicityConstraint constraint = new UnicityConstraint();
	Collection<FieldInformations> fieldList = constraint.getFields();
	assert(fieldList.size() == 0);
    }

    @Test
    public void testAddField() {
	UnicityConstraint constraint = new UnicityConstraint();
	FieldInformations fieldInfo = new FieldInformations("age", FieldType.Type.INTEGER, true);
	constraint.addField(fieldInfo);
	Collection<FieldInformations> fieldList = constraint.getFields();
	assert(fieldList.size() == 1);
    }
}
