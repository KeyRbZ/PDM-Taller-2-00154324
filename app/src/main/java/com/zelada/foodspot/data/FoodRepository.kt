package com.zelada.foodspot.data

import com.zelada.foodspot.model.Dish
import com.zelada.foodspot.model.Restaurant

interface FoodRepository {

    fun getRestaurants(): List<Restaurant>
    fun searchRestaurants(query: String): List<Restaurant>
}

class FoodRepositoryImpl : FoodRepository {

    private val restaurants: List<Restaurant> = listOf(

        Restaurant(
            id = 1,
            name = "Burger House",
            description = "Las mejores hamburguesas artesanales de la ciudad, preparadas al momento con ingredientes frescos.",
            imageUrl = "https://images.unsplash.com/photo-1568901346375-23c9450c58cd?w=800",
            categories = listOf("Comida Rápida"),
            menu = listOf(
                Dish(
                    1,
                    "Clásica BBQ",
                    "Carne de res, bacon, queso cheddar y salsa BBQ ahumada",
                    "https://images.unsplash.com/photo-1550317138-10000687a72b?w=600"
                ),
                Dish(
                    2,
                    "Doble Queso",
                    "Doble carne con queso americano, pepinillos y mostaza",
                    "https://images.unsplash.com/photo-1586190848861-99aa4a171e90?w=600"
                ),
                Dish(
                    3,
                    "Mushroom Swiss",
                    "Carne de res con champiñones salteados y queso suizo",
                    "https://images.unsplash.com/photo-1561758033-d89a9ad46330?w=600"
                ),
                Dish(
                    4,
                    "Papas Fritas",
                    "Papas doradas crujientes con sal marina",
                    "https://images.unsplash.com/photo-1573080496219-bb080dd4f877?w=600"
                )
            )
        ),
        Restaurant(
            id = 2,
            name = "Pollo Loco",
            description = "Pollo asado al carbón con marinados especiales de la casa, directo a tu mesa.",
            imageUrl = "https://images.unsplash.com/photo-1626645738196-c2a7c87a8f58?w=800",
            categories = listOf("Comida Rápida"),
            menu = listOf(
                Dish(
                    5,
                    "Pollo Entero",
                    "Pollo entero asado con chimichurri casero",
                    "https://images.unsplash.com/photo-1587593810167-a84920ea0781?w=600"
                ),
                Dish(
                    6,
                    "Alitas BBQ",
                    "Alitas de pollo bañadas en salsa BBQ ahumada",
                    "https://images.unsplash.com/photo-1567620832903-9fc6debc209f?w=600"
                ),
                Dish(
                    7,
                    "Wrap de Pollo",
                    "Tortilla de harina, pollo grillado, lechuga y aderezo ranch",
                    "https://images.unsplash.com/photo-1626700051175-6818013e1d4f?w=600"
                )
            )
        ),
        Restaurant(
            id = 3,
            name = "Tacos Mex",
            description = "Auténtica comida mexicana, tacos y burritos preparados con recetas tradicionales.",
            imageUrl = "https://images.unsplash.com/photo-1565299585323-38d6b0865b47?w=800",
            categories = listOf("Comida Rápida", "Mexicana"),
            menu = listOf(
                Dish(
                    8,
                    "Taco al Pastor",
                    "Carne de cerdo marinada, piña, cilantro y cebolla",
                    "https://images.unsplash.com/photo-1551504734-5ee1c4a1479b?w=600"
                ),
                Dish(
                    9,
                    "Burrito Supremo",
                    "Tortilla grande, frijoles, arroz, carne y pico de gallo",
                    "https://images.unsplash.com/photo-1626700051175-6818013e1d4f?w=600"
                ),
                Dish(
                    10,
                    "Quesadilla",
                    "Tortilla de maíz con queso Oaxaca y tus ingredientes favoritos",
                    "https://images.unsplash.com/photo-1618040996337-56904b7850b9?w=600"
                ),
                Dish(
                    11,
                    "Nachos con Guac",
                    "Nachos tostados con guacamole fresco y jalapeños",
                    "https://images.unsplash.com/photo-1513456852971-30c0b8199d4d?w=600"
                )
            )
        ),

        Restaurant(
            id = 4,
            name = "Pizza Place",
            description = "Las mejores pizzas artesanales de la ciudad, con ingredientes frescos y masa madre.",
            imageUrl = "https://images.unsplash.com/photo-1534308983496-4fabb1a015ee?w=800",
            categories = listOf("Italiana"),
            menu = listOf(
                Dish(
                    12,
                    "Pizza Margarita",
                    "Mozzarella fresca, albahaca y salsa de tomate casera",
                    "https://images.unsplash.com/photo-1565299624946-b28f40a0ae38?w=600"
                ),
                Dish(
                    13,
                    "Pizza Pepperoni",
                    "Pepperoni, mozzarella y salsa picante opcional",
                    "https://images.unsplash.com/photo-1534308983496-4fabb1a015ee?w=600"
                ),
                Dish(
                    14,
                    "Pizza Cuatro Quesos",
                    "Mozzarella, parmesano, gorgonzola y ricotta",
                    "https://images.unsplash.com/photo-1528137871618-79d2761e3fd5?w=600"
                ),
                Dish(
                    15,
                    "Pizza Hawaiana",
                    "Jamón, piña, mozzarella y salsa de tomate",
                    "https://images.unsplash.com/photo-1565299585323-38d6b0865b47?w=600"
                )
            )
        ),
        Restaurant(
            id = 5,
            name = "Bella Pasta",
            description = "Pasta fresca hecha a mano todos los días, con salsas italianas de receta familiar.",
            imageUrl = "https://images.unsplash.com/photo-1555949258-eb67b1ef0ceb?w=800",
            categories = listOf("Italiana"),
            menu = listOf(
                Dish(
                    16,
                    "Spaghetti Carbonara",
                    "Pasta, huevo, panceta, parmesano y pimienta negra",
                    "https://images.unsplash.com/photo-1612874742237-6526221588e3?w=600"
                ),
                Dish(
                    17,
                    "Fettuccine Alfredo",
                    "Pasta ancha con crema, mantequilla y parmesano",
                    "https://images.unsplash.com/photo-1563379926898-05f4575a45d8?w=600"
                ),
                Dish(
                    18,
                    "Lasaña Bolognesa",
                    "Capas de pasta, carne molida, bechamel y parmesano",
                    "https://images.unsplash.com/photo-1574894709920-11b28e7367e3?w=600"
                ),
                Dish(
                    19,
                    "Risotto Funghi",
                    "Arroz cremoso con champiñones y parmesano",
                    "https://images.unsplash.com/photo-1476124369491-e7addf5db371?w=600"
                )
            )
        ),

        Restaurant(
            id = 6,
            name = "Sushi Bar",
            description = "Sushi fresco preparado por chefs japoneses con ingredientes importados.",
            imageUrl = "https://images.unsplash.com/photo-1579871494447-9811cf80d66c?w=800",
            categories = listOf("Asiática", "Japonesa"),
            menu = listOf(
                Dish(
                    20,
                    "Nigiri Salmón",
                    "Arroz de sushi con lámina de salmón fresco",
                    "https://images.unsplash.com/photo-1559410545-0bdcd187e0a6?w=600"
                ),
                Dish(
                    21,
                    "Roll California",
                    "Cangrejo, aguacate y pepino envuelto en arroz",
                    "https://images.unsplash.com/photo-1564489563601-c53cfc451e93?w=600"
                ),
                Dish(
                    22,
                    "Ramen Tonkotsu",
                    "Caldo de cerdo, fideos ramen, huevo marinado y nori",
                    "https://images.unsplash.com/photo-1569050467447-ce54b3bbc37d?w=600"
                ),
                Dish(
                    23,
                    "Gyoza",
                    "Dumplings de cerdo y verduras al vapor con salsa ponzu",
                    "https://images.unsplash.com/photo-1535399831218-d5bd36d1a6b3?w=600"
                )
            )
        ),
        Restaurant(
            id = 7,
            name = "Wok Express",
            description = "Cocina china rápida y deliciosa, salteados y arroz frito al estilo tradicional.",
            imageUrl = "https://images.unsplash.com/photo-1563245372-f21724e3856d?w=800",
            categories = listOf("Asiática", "China"),
            menu = listOf(
                Dish(
                    24,
                    "Arroz Frito Especial",
                    "Arroz con pollo, camarones, verduras y huevo",
                    "https://images.unsplash.com/photo-1603133872878-684f208fb84b?w=600"
                ),
                Dish(
                    25,
                    "Pollo General Tso",
                    "Pollo crujiente en salsa agridulce con brócoli",
                    "https://images.unsplash.com/photo-1525755662778-989d0524087e?w=600"
                ),
                Dish(
                    26,
                    "Chow Mein",
                    "Fideos salteados con pollo, verduras y salsa de soya",
                    "https://images.unsplash.com/photo-1603133872878-684f208fb84b?w=600"
                ),
                Dish(
                    27,
                    "Spring Rolls",
                    "Rollos de primavera crujientes con verduras y salsa dulce",
                    "https://images.unsplash.com/photo-1548943487-a2e4e43b4853?w=600"
                )
            )
        ),

        Restaurant(
            id = 8,
            name = "Green Bowl",
            description = "Bowls nutritivos y ensaladas frescas para una alimentación equilibrada y sabrosa.",
            imageUrl = "https://images.unsplash.com/photo-1512621776951-a57141f2eefd?w=800",
            categories = listOf("Saludable"),
            menu = listOf(
                Dish(
                    28,
                    "Buddha Bowl",
                    "Quinoa, garbanzos, aguacate, tomate cherry y tahini",
                    "https://images.unsplash.com/photo-1512621776951-a57141f2eefd?w=600"
                ),
                Dish(
                    29,
                    "Ensalada César",
                    "Lechuga romana, crutones, parmesano y aderezo César",
                    "https://images.unsplash.com/photo-1550304943-4f24f54ddde9?w=600"
                ),
                Dish(
                    30,
                    "Wrap Vegano",
                    "Tortilla integral, hummus, verduras asadas y rúcula",
                    "https://images.unsplash.com/photo-1626700051175-6818013e1d4f?w=600"
                ),
                Dish(
                    31,
                    "Açaí Bowl",
                    "Base de açaí con granola, fresas, plátano y miel",
                    "https://images.unsplash.com/photo-1490474418585-ba9bad8fd0ea?w=600"
                )
            )
        ),

        Restaurant(
            id = 9,
            name = "Sweet Dreams",
            description = "Pastelería artesanal con los postres más creativos y deliciosos de la ciudad.",
            imageUrl = "https://images.unsplash.com/photo-1578985545062-69928b1d9587?w=800",
            categories = listOf("Postres"),
            menu = listOf(
                Dish(
                    32,
                    "Cheesecake NY",
                    "Tarta de queso estilo Nueva York con frutos rojos",
                    "https://images.unsplash.com/photo-1533134242443-d4fd215305ad?w=600"
                ),
                Dish(
                    33,
                    "Brownie Fudge",
                    "Brownie de chocolate con nueces y helado de vainilla",
                    "https://images.unsplash.com/photo-1564355808539-22fda35bed7e?w=600"
                ),
                Dish(
                    34,
                    "Macarons Variados",
                    "Selección de 6 macarons de distintos sabores",
                    "https://images.unsplash.com/photo-1569864358642-9d1684040f43?w=600"
                ),
                Dish(
                    35,
                    "Tiramisu",
                    "Postre italiano con café, mascarpone y cacao",
                    "https://images.unsplash.com/photo-1571877227200-a0d98ea607e9?w=600"
                )
            )
        ),

        Restaurant(
            id = 10,
            name = "Juice Lab",
            description = "Jugos naturales, smoothies y bebidas saludables preparadas al momento.",
            imageUrl = "https://images.unsplash.com/photo-1610970881699-44a5587cabec?w=800",
            categories = listOf("Bebidas", "Saludable"),
            menu = listOf(
                Dish(
                    36,
                    "Green Detox",
                    "Espinaca, pepino, manzana verde, jengibre y limón",
                    "https://images.unsplash.com/photo-1622597467836-f3285f2131b8?w=600"
                ),
                Dish(
                    37,
                    "Smoothie Tropical",
                    "Mango, piña, coco y leche de almendras",
                    "https://images.unsplash.com/photo-1553530666-ba11a7da3888?w=600"
                ),
                Dish(
                    38,
                    "Cold Brew Coffee",
                    "Café preparado en frío por 24 horas, suave e intenso",
                    "https://images.unsplash.com/photo-1461023058943-07fcbe16d735?w=600"
                ),
                Dish(
                    39,
                    "Limonada Menta",
                    "Limonada natural con hierbabuena y miel",
                    "https://images.unsplash.com/photo-1556679343-c7306c1976bc?w=600"
                )
            )
        ),

        Restaurant(
            id = 11,
            name = "Pho Saigon",
            description = "Auténtica sopa vietnamita Pho y platos asiáticos llenos de sabor.",
            imageUrl = "https://images.unsplash.com/photo-1582878826629-29b7ad1cdc43?w=800",
            categories = listOf("Asiática", "Vietnamita"),
            menu = listOf(
                Dish(
                    40,
                    "Pho Bo",
                    "Sopa de res con fideos de arroz, brotes y hierbas frescas",
                    "https://images.unsplash.com/photo-1582878826629-29b7ad1cdc43?w=600"
                ),
                Dish(
                    41,
                    "Banh Mi",
                    "Baguette vietnamita con cerdo, pickles y cilantro",
                    "https://images.unsplash.com/photo-1599599810769-bcde5a160d32?w=600"
                ),
                Dish(
                    42,
                    "Bun Bo Hue",
                    "Sopa picante con fideos gruesos y carne de res",
                    "https://images.unsplash.com/photo-1555126634-323283e090fa?w=600"
                )
            )
        )
    )

    override fun getRestaurants(): List<Restaurant> = restaurants
    override fun searchRestaurants(query: String): List<Restaurant> {
        if (query.isBlank()) return emptyList()

        val queryLower = query.lowercase()

        return restaurants.filter { restaurant ->
            val matchesName = restaurant.name.lowercase().contains(queryLower)

            val matchesDish = restaurant.menu.any { dish ->
                dish.name.lowercase().contains(queryLower)
            }

            matchesName || matchesDish
        }
    }
}
