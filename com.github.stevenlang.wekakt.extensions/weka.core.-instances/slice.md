[wekakt](../../index.md) / [com.github.stevenlang.wekakt.extensions](../index.md) / [weka.core.Instances](index.md) / [slice](./slice.md)

# slice

`fun `[`Instances`](http://weka.sourceforge.net/doc.stable/weka/core/Instances.html)`.slice(rangeRows: `[`IntRange`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.ranges/-int-range/index.html)`, rangeAttributes: `[`IntRange`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.ranges/-int-range/index.html)`): `[`Instances`](http://weka.sourceforge.net/doc.stable/weka/core/Instances.html)

Slice the given range of attributes out of the dataset.

``` kotlin
val iris: Instances = getIris()

// Get rows from 5 to 50 and attributes from 2 to 3
val sliced: Instances = iris.slice(5..50, 2..3)
```

### Parameters

`rangeRows` - Range of ints indicating the row slice interval

`rangeAttributes` - Range of ints indicating the attribute slice interval

**Return**
Subset of this dataset, that is only the attributes and rows in the given ranges are in
the result
