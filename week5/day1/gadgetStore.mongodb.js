// challenege - mini project:
const gadgetDB = db.getSiblingDB('gadgetStore');

//Create a collection named products with a JSON Schema validator requiring:
//      name (must be a string)
//      price (must be an integer or double)
//      inStock (must be a boolean)
gadgetDB.createCollection('products', {
    validator: {
        $jsonSchema: {
            bsonType: 'object',
            required: ['name', 'price', 'inStock'],
            properties : {
                name: {
                    bsonType: 'string'
                },
                price: {
                    bsonType: ['int', 'double']
                },
                inStock: {
                    bsonType: 'bool'
                }
            }
        }
    },
    validationAction: 'error'
});

// Use insertMany() to add at least three different gadgets (e.g., Wireless Mouse, Mechanical Keyboard, Gaming Monitor).
// Make sure they match your schema, and include a nested specs sub-document with a brand field (e.g., specs: { brand: "Logitech" }).
//const gadgetDB = db.getSiblingDB('gadgetStore');

gadgetDB.products.insertMany([
    {
        name: 'wireless mouse', price: 19.99, inStock: true, specs: {
            brand: 'logitech'
        } },
        {
            name: 'mechinical keyboard', price: 90.5, inStock: true, specs: {
                brand: 'keychron'
            }
        },
        {
            name: 'gaming monitor', price: 310.99, inStock: false, specs: {
                brand: 'deli'
            }
        }
]);
gadgetDB.products.countDocuments();

// Test your validation by trying to insertOne() a product that violates your rules (like missing the price field or giving it the wrong data type).
try {
    gadgetDB.products.insertOne({
        name: 'broken gadget', inStock: true
    });
} catch (e) {
    console.log('missing price!', e.message);
}

try {
    gadgetDB.products.insertOne({
        name: 'broken gadget 2.0', price: 'cheap', inStock: true
    });
} catch (e) {
    console.log('price cant be string, whoopsie', e.message);
}

// Choose one product and use updateOne() with $set to add a new top-level field called category with the value "Accessories".
gadgetDB.products.updateOne({
    name: 'wireless mouse'
},
{
    $set: {
        category: 'accessories'
    }
});

// Use $inc to increase its price by 15 dollars.
gadgetDB.products.updateOne({ 
    name: 'Wireless Mouse' 
},
  { 
    $inc: { 
        price: 15 
    }}
);

// Add an array field called tags to that product using $push to add "wireless". Then, use $push again to add "bestseller".
gadgetDB.products.updateOne({
    name: 'wireless mouse'
},
{
    $push: {
        tags: 'wireless'
    }
});

gadgetDB.products.updateOne({
    name: 'wireless mouse'
},
{
    $push: {
        tags: 'bestseller'
    }
});

// Decide you don't want "wireless" after all, and use $pull to remove it from the tags array.
gadgetDB.products.updateOne({
    name: 'wireless mouse'
},
{
    $pull: {
        tags: 'wireless'
    }
});

// check the result
gadgetDB.products.findOne({
    name: 'wireless mouse'
});

// Find all products priced greater than or equal to a certain amount using $gte.
gadgetDB.products.find({
    price: {
        $gte: 50
    }
});

// Find all products made by a specific brand using dot notation (e.g., "specs.brand").
gadgetDB.products.find({
    'specs.brand': 'logitech'
});

// Find products whose category matches one in a list using $in.
gadgetDB.products.find({
    category: {
        $in: ['accessories', 'monitors']
    }
});

// Create a second collection named orders.
// Insert a document into orders that links a product's _id to an order (e.g., { productId: <ObjectId_from_product>, quantity: 2 }).
gadgetDB.createCollection('orders');

const mouse = gadgetDB.products.findOne({
    name: 'wireless mouse'
});

gadgetDB.orders.insertOne({
    productId: mouse._id,
    quantity: 2
});

// Write an aggregation pipeline on the orders collection using $lookup and $unwind to join orders with products.
// Use $project to output a clean customer receipt showing:
//      The product name ($product.name)
//      The ordered quantity (quantity)
//      Hiding the _id field.
gadgetDB.orders.aggregate([
    {
        $lookup: {
          from: 'products',
          localField: 'productId',
          foreignField: '_id',
          as: 'product'
        }
    },
    {
        $unwind: '$product'
    },
    {
        $project: {
          _id: 0,
          productName: '$product.name',
          quantity: 1
        }
    }
]);