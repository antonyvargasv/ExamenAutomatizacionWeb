#language: es
@testfeature
Característica: Product - Store

  Esquema del escenario: : Validación del precio de un producto

    Dado estoy en la página de la tienda
    Y me logueo con mi usuario "<usuario>" y clave "<clave>"
    Cuando navego a la categoria "<categoria>" y subcategoria "<subcategoria>"
    Y agrego "<cantidad>" unidades del primer producto al carrito
    Entonces valido en el popup la confirmación del producto agregado
    Y valido en el popup que el monto total sea calculado correctamente
    Cuando finalizo la compra
    Entonces valido el titulo de la pagina del carrito
    Y vuelvo a validar el calculo de precios en el carrito
    Ejemplos:
      | usuario              | clave      | categoria | subcategoria |cantidad|
      | vvargasa18@gmail.com  | qalab2024@ | clothes   | men          |2       |
      | vvargasa18@gmail.com  | qalabxaxa@ | clothes   | men          |2       |


