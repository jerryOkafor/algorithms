var FIX_MARGIN_TOP = 20;
var FIX_MARGIN_LEFT = 20;

var displayArray = function (array, startX, startY, canvasX, canvasY, stepHeight) {
    textFont(createFont("monospace"), 12);
    fill(255, 0, 0);
    var cellMargin = 1;
    var cellWidth = canvasX / array.length;

    for (var i = 0; i < array.length; i++) {
        var x = startX + i * cellWidth + FIX_MARGIN_LEFT;
        var y = startY + FIX_MARGIN_TOP + stepHeight;
        text(array[i], x, y);
    }

};

var drawLine = function (array, startX, startY, canvasX, canvasY, stepHeight, minIndex, index) {
    var cellWidth = canvasX / array.length;
    var firstY = FIX_MARGIN_TOP + stepHeight * index;
    stepHeight = stepHeight * (index + 1);

    var x1 = startX + minIndex * cellWidth + FIX_MARGIN_LEFT;
    var y1 = startY + firstY;
    var x2 = startX + index * cellWidth + FIX_MARGIN_LEFT;
    var y2 = startY + FIX_MARGIN_TOP + stepHeight;

    line(x1, y1, x2, y2);
};


var swap = function (array, firstIndex, secondIndex) {
    var temp = array[firstIndex];
    array[firstIndex] = array[secondIndex];
    array[secondIndex] = temp;
};

var indexOfMinimum = function (array, startIndex) {
    // console.log("Array Size: ",array.length)
    var minIndex = startIndex;
    var minValue = array[minIndex];

    for (var i = minIndex + 1; i < array.length; i++) {
        if (array[i] < minValue) {
            minIndex = i;
            minValue = array[i];
        }

    }
    return minIndex;
};

var selectionSort = function (array, startX, startY, displayWidth, displayHeight) {
    var cellHeight = displayHeight / array.length;
    var rowGap = 40;

    displayArray(array, startX, startY, displayWidth, displayHeight, 0);
    // drawLine(array,startX,startY,displayWidth,displayHeight,rowGap,4,0);

    for (var i = 0; i < array.length; i++) {
        var indexOfMinValue = indexOfMinimum(array, i);
        swap(array, i, indexOfMinValue);

        var stepHeight = rowGap * (i + 1);
        displayArray(array, startX, startY, displayWidth, displayHeight, stepHeight);

        drawLine(array, startX, startY, displayWidth, displayHeight, rowGap, indexOfMinValue, i);
    }

};

var array = [22, 11, 99, 88, 9];
selectionSort(array, 0, 0, width / 2, height / 2);

var array1 = [5, 4, 3, 2, 1];
array1 = selectionSort(array1, width / 2, 0, width / 2, height / 2);

var array2 = [10, 9, 8, 7, 6];
array2 = selectionSort(array2, 0, height / 2, width / 2, height / 2);

var array3 = [10, 9, 8, 7, 6];
array3 = selectionSort(array3, width / 2, height / 2, width / 2, height / 2);
