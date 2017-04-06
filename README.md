# Design description
### Items:
1) Basic item information is stored in abstract class Item. Having base class allows for polymorphism
2) Item is subclass depending on the item type: weightable and countable. There is possibility to easily add another
item types without need for changing existing code
3) Item object are immutable and can be stored as Collection keys and values
4) Promotions can be applied on the basis of Item class. That means promotions can also be applied to weightable items
or any other type of items possible in the future
### Basket:
1) Basket is simple container, which holds items collected by customer before checking out
2) Basket groups CountableItems. This grouping is unnecessary for correct Purchase operations, but is implemented to
save memory
3) WeightableItems with different weights are not grouped in Basket, since it would involve Basket distinguishing
between items, which is not Basket responsibility
### Purchase
1) Contains logic for price and discount calculation
2) Before applying any of promotions via Strategy pattern, Purchase groups all similar items into Maps, which is
then passed to any of elected promotions
3) Grouping allows Promotion methods to calculate exact amount of items of each type (including summing the weight of
multiple weightable items, i.e. multiple bags of oranges with different weight),
### Promotion
1) Promotion are Strategy object, which responsibility is to distinguish, if passed items are suitable for discount
based on this promotion rules

# Assumptions
1) Item number of items bought is too small to be affected by double value imprecision
2) There can be only one promotion at time for each product
3) Product information is entered correctly and barcodes are unique for unique items
4) Promotion affected barcodes are entered correctly and for intended type of items

# Build instructions
1) This is Maven-based project: clone git repository into folder on your machine and run mvn install
