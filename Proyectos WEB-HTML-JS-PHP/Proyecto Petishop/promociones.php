<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Promociones</title>
    <link rel="stylesheet" type="text/css" href="css/all.css">
 <style>

@import url('https://fonts.googleapis.com/css?family=Open+Sans');


* {font-family: Helvetica Neue, Arial, sans-serif; }

body {
  background-image: linear-gradient(-225deg, #E3FDF5 0%, #fe0457 100%);
background-image: linear-gradient(to top, #a8edea 0%, #d8634b 100%);
background-attachment: fixed;
background-repeat: no-repeat;

  font-family: 'Vibur', cursive;
/*   the main font */
  font-family: 'Abel', sans-serif;
opacity: .95;
/* background-image: linear-gradient(to top, #d9afd9 0%, #97d9e1 100%); */




}    


button{
    
    color: #494949 !important;
      text-decoration: none;
      background: #cf6766;
      border: 2px solid #494949 !important;
      display: inline-block;
      transition: all 0.4s ease 0s;
    
    }
    
    button:hover {
      color: #cf6766 !important;
      background: #cf6766;
      border-color: #0000FF !important;
      transition: all 0.4s ease 0s;
    }
    


* {
	box-sizing: border-box;
}

body {
	background-color: #f6f5f7;
	font-family: 'Open Sans', sans-serif;
	margin-bottom: 50px;
}

.text-center {
	text-align: center;
}

.pricing-box-container {
	display: flex;
	align-items: center;
	justify-content: center;
	flex-wrap: wrap;
}

.pricing-box {
	background-color: #ffffff;
	box-shadow: 0px 2px 15px 0px rgba(0,0,0,0.5);
	border-radius: 4px;
	flex: 1;
	padding: 0 30px 30px;
	margin: 2%;
	min-width: 250px;
	max-width: 350px;
}

.pricing-box h5 {
	text-transform: uppercase;
}

.price {
	margin: 24px 0;
	font-size: 36px;
	font-weight: 900;
}

.price sub, .price sup {
	font-size: 16px;
	font-weight: 100;
}

.features-list {
	padding: 0;
	list-style-type: none;
}

.features-list li {
	font-weight: 100;
	padding: 12px 0;
	font-weight: 100;
}

.features-list li:not(:last-of-type) {
	border-bottom: 1px solid rgba(0, 0, 0, 0.1);
}

.btn-primary {
	border-radius: 25px;
	border: none;
	background-color: #cf6766;
	color: #ffffff;
	cursor: pointer;
	padding: 10px 15px;
	margin-top: 20px;
	text-transform: uppercase;
	transition: all 0.1s ease-in-out;
}

.btn-primary:hover {
	box-shadow: 0px 2px 15px 0px rgba(0,0,0,0.5);
	transform: translateY(-3px);
}

.pricing-box-bg-image {
	background-image: url('https://images.unsplash.com/photo-1550029402-226115b7c579?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=701&q=80');
	background-size: cover;
	background-position: center center;
	color: #ffffff;
}

.pricing-box-bg-image2 {
	background-image: url('imagenes/sony.jpg');
	background-size: cover;
	background-position: center center;
	color: #ffffff;
}


.pricing-box-bg-image3 {
	background-image: url('imagenes/samsumg.jpg');
	background-size: cover;
	background-position: center center;
	color: #ffffff;
}



.pricing-box-bg-image .features-list li {
	border-bottom-color: rgba(255, 255, 255, 1);
}

.pricing-box-bg-image .btn-primary {
	background-color: #ffffff;
	color: #000;
}






footer {
	background-color: #222;
	color: #fff;
	font-size: 14px;
	bottom: 0;
	position: fixed;
	left: 0;
	right: 0;
	text-align: center;
}

footer p {
	margin: 10px 0;
}

footer i {
	color: red;
}

footer a {
	color: #cf6766;
	text-decoration: none;
}


a {
    text-decoration: none;
    text-transform: uppercase;
    font-size: 30px;
}
a span {
    padding: 15px;
    transition: .5s;
    position: relative;
}
a span:nth-child(1) {
    color: #fff;
    background: #262626;
}
a span:nth-child(2) {
    color: #fff;
    background: #ff3636;
}
a span:nth-child(1):before {
    content: attr(data-attr);
    position: absolute;
    top: 0;
    left: 0;
    background: #ff3636;
    padding: 15px;
    transition: 0.5S;
    transform-origin: top;
    transform: rotateX(90deg) translateY(-50%);
}
a:hover span:nth-child(1):before {
    transform: rotateX(0deg) translateY(0%);
} 
a span:nth-child(2):before {
    content: attr(data-attr);
    position: absolute;
    top: 0;
    left: 0;
    background: #262626;
    padding: 15px;
    transition: 0.5S;
    transform-origin: bottom;
    transform: rotateX(90deg) translateY(50%);
}
a:hover span:nth-child(2):before {
    transform: rotateX(0deg) translateY(0%);
} 
a  span:nth-child(1):after {
  content: attr(data-attr);
  padding: 15px;
  position: absolute;
  top: 0;
  left: 0;
  background: #262626;
  transform-origin: bottom;
  transform: rotateX(0deg) translateY(0%);
  transition: 0.5s;
}
a:hover span:nth-child(1):after {
  transform: rotateX(90deg) translateY(50%);
}
a span:nth-child(2):after {
    content: attr(data-attr);
    position: absolute;
    top: 0;
    left: 0;
    background: #ff3636;
    padding: 15px;
    transition: 0.5S;
    transform-origin: top;
    transform: rotateX(0deg) translateY(0%);
}
a:hover span:nth-child(2):after {
    transform: rotateX(90deg) translateY(-50%);
} 

    



 </style>
</head>
<body>



<div class="center">
      <a href="home.php"><span data-attr="Exit">Exit</span><span data-attr="Exit">Exit</span></a>
  </div>

<h1 class="text-center">Aprovecha y adquiere</h1>


<div class="pricing-box-container">
<div class="pricing-box pricing-box-bg-image text-center pricing-box-bg-image2">
		<h5>Todos los articulos</h5>
		<p class="price">Sony</p>
		<ul class="features-list">
			<li><strong>-20% OFF</strong> Computadoras</li>
			<li><strong>-30% OFF</strong> Smartphones</li>
			<li><strong>2x1</strong> Earpods</li>
			<li><strong>-35% OFF </strong>Camaras</li>
		</ul>
		<button class="btn-primary">Obtener</button>
	</div>

	<div class="pricing-box pricing-box-bg-image text-center pricing-box-bg-image3" >
    <h5>Todos los articulos</h5>
		<p class="price">Samsumg</p>
		<ul class="features-list">
        <li><strong>-20% OFF</strong> Computadoras</li>
			<li><strong>-30% OFF</strong> Smartphones</li>
			<li><strong>2x1</strong> Earpods</li>
			<li><strong>-35% OFF</strong>Camaras</li>
		</ul>
		<button class="btn-primary">Obtener</button>
	</div>

	<div class="pricing-box pricing-box-bg-image text-center">
    <h5>Todos los articulos</h5>
    <p class="price">Apple</p>
		<ul class="features-list">
        <li><strong>-10% OFF</strong> Computadoras</li>
			<li><strong>-45% OFF</strong> Smartphones</li>
			<li><strong>2x1</strong> Earpods</li>
			<li><strong>-35 OFF </strong>Apple Watch</li>
		</ul>
		<button class="btn-primary">Obtener</button>
	</div>
</div>

<footer>
	<p>

		<a>Petishop</a>
	</p>
</footer>
</body>
</html>