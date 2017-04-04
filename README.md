# Design considerations
## Items:
1) First idea is to create simple POJO object representation and then store them in collection, tracking item count
2) However, this seems to flood basket class with responsibilities: keep track of objects, grouping, price calculation,
applying promotions
3) This leads to idea to create separate object to represent groups of items. This seems better structure as this
object will have behaviour. This also keeps our basket more lightweight in terms of memory consumption, as it doesn't
hold full POJO objects with all the data, that might be unnecessary at this level
## Basket:
1) Basket must contain item group list and promotion list as these need to be individual for every customer
## Promotion
1) Promotion objects are good candidate for being strategy objects
