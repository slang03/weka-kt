package extensions

import org.junit.Assert
import org.junit.Before
import org.junit.Test
import weka.core.DenseInstance
import weka.core.Instances
import weka.filters.Filter
import weka.filters.unsupervised.instance.RemovePercentage

/**
 * Tests for Weka [Instances] extensions.
 *
 * @author Steven Lang
 */
class ExtensionsInstancesTest {

    /**
     * Test dataset
     */
    private lateinit var iris: Instances

    @Before
    fun init() {
        iris = Instances("src/test/resources/datasets/iris.arff")
    }

    @Test
    fun testGetSet() {
        val irisCopy = Instances(iris, iris.size)
        for (i in 0 until iris.size) {
            irisCopy.add(DenseInstance(iris.numAttributes()))
            irisCopy[i] = iris[i]

            Assert.assertTrue(iris[i].isEquals(irisCopy[i]))
        }
    }

    @Test
    fun testFilter() {
        val rp = RemovePercentage()
        rp.invertSelection = false
        rp.percentage = 20.0
        rp.setInputFormat(iris)

        val filteredWeka = Filter.useFilter(iris, rp)
        val filteredKotlin = iris.filter(RemovePercentage()) {
            invertSelection = false
            percentage = 20.0
        }

        Assert.assertTrue(filteredWeka.isEquals(filteredKotlin))
    }
}