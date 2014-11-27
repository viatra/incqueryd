/*******************************************************************************
 * Copyright (c) 2010-2014, Gabor Szarnyas, Istvan Rath and Daniel Varro
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Gabor Szarnyas - initial API and implementation
 *******************************************************************************/
package hu.bme.mit.incqueryd.engine.rete.dataunits;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import hu.bme.mit.incqueryd.engine.rete.dataunits.ChangeSet;
import hu.bme.mit.incqueryd.engine.rete.dataunits.ChangeType;
import hu.bme.mit.incqueryd.engine.rete.dataunits.Tuple;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

/**
 * Test cases for the {@link ChangeSet} class.
 * 
 * @author szarnyasg
 * 
 */
public class ChangeSetTest {

    @Test
    public void test1() {
        final Set<Tuple> tuples1 = new HashSet<>();
        final Set<Tuple> tuples2 = new HashSet<>();

        tuples1.add(new Tuple(1, 2));
        tuples2.add(new Tuple(1, 2));

        final ChangeSet changeSet1 = new ChangeSet(tuples1, ChangeType.POSITIVE);
        final ChangeSet changeSet2 = new ChangeSet(tuples2, ChangeType.POSITIVE);

        assertTrue(changeSet1.equals(changeSet2));
        assertTrue(changeSet2.equals(changeSet1));
    }

    @Test
    public void test2() {
        final Set<Tuple> tuples1 = new HashSet<>();
        final Set<Tuple> tuples2 = new HashSet<>();

        tuples1.add(new Tuple(1, 2));
        tuples1.add(new Tuple(3, 4));

        tuples2.add(new Tuple(3, 4));
        tuples2.add(new Tuple(1, 2));

        final ChangeSet changeSet1 = new ChangeSet(tuples1, ChangeType.POSITIVE);
        final ChangeSet changeSet2 = new ChangeSet(tuples2, ChangeType.POSITIVE);

        assertTrue(changeSet1.equals(changeSet2));
        assertTrue(changeSet2.equals(changeSet1));
    }

    @Test
    public void test3() {
        final Set<Tuple> tuples1 = new HashSet<>();
        final Set<Tuple> tuples2 = new HashSet<>();

        tuples1.add(new Tuple(1, 2));

        tuples2.add(new Tuple(3, 4));
        tuples2.add(new Tuple(1, 2));

        final ChangeSet changeSet1 = new ChangeSet(tuples1, ChangeType.POSITIVE);
        final ChangeSet changeSet2 = new ChangeSet(tuples2, ChangeType.POSITIVE);

        assertFalse(changeSet1.equals(changeSet2));
        assertFalse(changeSet2.equals(changeSet1));
    }

}
