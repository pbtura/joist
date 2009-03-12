package features.domain;

import junit.framework.Assert;

import org.exigencecorp.jdbc.Jdbc;

import features.Registry;

public class OpLockATest extends AbstractFeaturesTest {

    public void testLoadChildren() {
        Parent p = new Parent("parent");
        this.commitAndReOpen();

        p = this.reload(p);
        p.setName("parent2");

        // Change it first
        Jdbc.update(Registry.getDataSource(), "UPDATE parent SET name = 'changed', version = 1");

        try {
            this.commitAndReOpen();
            Assert.fail();
        } catch (RuntimeException re) {
            Assert.assertEquals("Op lock failed for Parent[2]", re.getMessage());
        }
    }

}