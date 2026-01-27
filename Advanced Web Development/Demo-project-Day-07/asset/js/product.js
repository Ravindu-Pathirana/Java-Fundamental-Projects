function getProducts() {
  fetch("http://localhost:8080/product")
    .then((res) => res.json())
    .then((data) => {
      console.log("Products fetched successfully:", data);
    })
    .catch((error) => {
      console.error("Error fetching products:", error);
    });
}
