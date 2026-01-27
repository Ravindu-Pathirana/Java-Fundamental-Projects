//Event listener for saving a product
document
  .getElementById("btn-save-product")
  .addEventListener("click", saveProduct);

//Function to save product data
function saveProduct() {
  let requestBody = mapRequest();

  fetch("http://localhost:8080/product", {
    method: "POST",
    body: JSON.stringify(requestBody),
    headers: {
      "Content-Type": "application/json",
    },
  })
    .then((res) => res.json())
    .then((data) => {
      console.log("Product saved successfully:", data);
    })
    .catch((error) => {
      console.error("Error saving product:", error);
    });
}

//Function to map form data to request body
function mapRequest() {
  let requestBody = {
    name: undefined,
    description: undefined,
    price: undefined,
    category: undefined,
  };

  requestBody.name = document.getElementById("txt-product-name").value;
  requestBody.description = document.getElementById(
    "txt-product-description",
  ).value;
  requestBody.price = parseFloat(
    document.getElementById("txt-product-price").value,
  );
  requestBody.category = document.getElementById("txt-product-category").value;
  return requestBody;
}
