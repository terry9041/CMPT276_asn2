document.addEventListener("DOMContentLoaded", function () {
  const widthInput = document.querySelector('input[name="width"]');
  const heightInput = document.querySelector('input[name="height"]');
  const fillColorInput = document.querySelector('input[name="fillColor"]');
  const borderColorInput = document.querySelector('input[name="borderColor"]');
  const rectangle = document.querySelector(".rectangle");

  // we need 2 query selectors as we need to get the input field and the display field
  const nameInput = document.querySelector('input[name="name"]');
  const nameDisplay = document.querySelector(".rectangle-name-display");

  function updateRectangle() {
    rectangle.style.width = widthInput.value + "px";
    rectangle.style.height = heightInput.value + "px";
    rectangle.style.backgroundColor = fillColorInput.value;
    rectangle.style.borderColor = borderColorInput.value;
    // Update the name display using textcontent property as we cannot use rectangle.style.name or rectangle.name
    nameDisplay.textContent = nameInput.value;
  }

  // Add event listeners to the input fields
  widthInput.addEventListener("input", updateRectangle);
  heightInput.addEventListener("input", updateRectangle);
  fillColorInput.addEventListener("input", updateRectangle);
  borderColorInput.addEventListener("input", updateRectangle);
  nameInput.addEventListener("input", updateRectangle);
});
