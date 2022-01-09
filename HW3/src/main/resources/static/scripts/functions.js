
cart = []
window.onload = get_products

function get_products() 
{
    axios.get('http://localhost:8080/products')
        .then(response =>
            print_products(response.data)
        )

}


function print_products(products)
{

    var tableStr = "<table class=\"table table-dark table-striped\">"
    tableStr += "<thead>"
    tableStr += "<tr>"
    tableStr += "<th scope=\"col\">Image</th>"
    tableStr += "<th scope=\"col\">Name</th>"
    tableStr += "<th scope=\"col\">Price</th>"
    tableStr += "<th scope=\"col\"></th>"

    tableStr += "</tr>"
    tableStr += "</thead>"
    tableStr += "<tbody>"
    
    for (p of products)
    {
        tableStr += "<tr>"
        tableStr += "<td><img src=\"" + p.icon + "\" width=\"100\" height=\"100\" alt='Something fishy is going on.. Try refresing the page :)'/></td>"
        tableStr += "<td>" + p.name + "</td>"
        tableStr += "<td>" + p.price + "</td>"
        //tableStr += "<td>" + p.quantity + "</td>";
        tableStr += "<td>" + "<button onclick=add_to_cart(" + JSON.stringify(p) + ")>Add to shopping cart</button></td>"
        tableStr += "</tr>"
    }

    tableStr += "</tbody>"
    tableStr += "</table>"
    document.getElementById("products").innerHTML = tableStr

}


function add_to_cart(product)
{
    cart.push(product)
    console.log(product)

    var tableStr = "<table class=\"table table-dark table-striped\">"
    tableStr += "<thead>"
    tableStr += "<tr>"
    
    tableStr += "<th scope=\"col\">Image</th>"
    tableStr += "<th scope=\"col\">Name</th>"
    tableStr += "<th scope=\"col\">Price</th>"
    tableStr += "<th scope=\"col\"></th>"

    tableStr += "</tr>"
    tableStr += "</thead>"
    tableStr += "<tbody>"

    total_price = 0.0
    for (var i = 0; i < cart.length; i++)
    {
        total_price += cart[i].price

        tableStr += "<tr>";
        tableStr += "<td><img src=\"" + cart[i].icon + "\" width=\"100\" height=\"100\" alt='Something fishy is going on.. Try refresing the page :)'/></td>"
        tableStr += "<td>" + cart[i].name + "</td>"
        tableStr += "<td>" + cart[i].price + "</td>"
        tableStr += "<td>" + "<button onclick=remove_from_cart("+ i +")>Remove from shopping cart</button></td>"
        tableStr += "</tr>";
    }

    tableStr += "</tbody>"
    tableStr += "<button onclick=checkout()>Checkout</button>"
    document.getElementById("cart").innerHTML = tableStr
    
    document.getElementById("items").innerHTML = "Item Count : " + cart.length
    document.getElementById("total").innerHTML = "Total Price : " + total_price
}

function refresh_table()
{
 
    var tableStr = "<table class=\"table table-dark table-striped\">"
    tableStr += "<thead>"
    tableStr += "<tr>"
    
    tableStr += "<th scope=\"col\">Image</th>"
    tableStr += "<th scope=\"col\">Name</th>"
    tableStr += "<th scope=\"col\">Price</th>"
    tableStr += "<th scope=\"col\"></th>"

    tableStr += "</tr>"
    tableStr += "</thead>"
    tableStr += "<tbody>"

    total_price = 0.0
    for (var i = 0; i < cart.length; i++)
    {
        total_price += cart[i].price
        tableStr += "<tr>";
        tableStr += "<td><img src=\"" + cart[i].icon + "\" width=\"100\" height=\"100\" alt='Something fishy is going on.. Try refresing the page :)'/></td>"
        tableStr += "<td>" + cart[i].name + "</td>"
        tableStr += "<td>" + cart[i].price + "</td>"
        tableStr += "<td>" + "<button onclick=remove_from_cart("+ i +")>Remove from shopping cart</button></td>"
        tableStr += "</tr>";
    }

    tableStr += "</tbody>";
    if (cart.length > 0)
    {
        tableStr += "<button onclick=checkout()>Checkout</button>"
    }
    tableStr += "</table>";
    document.getElementById("cart").innerHTML = tableStr
    
    document.getElementById("items").innerHTML = "Item Count : " + cart.length
    document.getElementById("total").innerHTML = "Total Price : " + total_price
}


function remove_from_cart(index)
{
    cart.splice(index, 1)
    refresh_table()
}

function checkout()
{
    var total_price = 0.0
    
    var dummy_json = {}
    var product_list = []
    
    dummy_json.products = product_list
    for(p of cart)
    {
        total_price += p.price
        var product_json = {
            "id": p.id,
        }
        dummy_json.products.push(product_json)
    }
    
    axios.post('http://localhost:8080/orders', 
    {
        amount: total_price,
        products : product_list
    }
    ).then(function (response) {
        console.log(response);
    }
    )
}
