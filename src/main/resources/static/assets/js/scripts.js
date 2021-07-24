function numberOnly(str) {
    var numb = str.match(/\d/g);
    numb = numb.join("");

    return parseInt(numb);
}

function sumNumber(data) {
    let sum = 0;
    for (let i = 0; i < data.length; i++) {
        const d = data[i];
        sum += (isNaN(d) ? 0 : parseFloat(data[i]));
    }
    return sum;
}

function sumCurrency(data) {
    let sum = 0;
    for (let i = 0; i < data.length; i++) {
        const d = numberOnly(data[i]);
        sum += (isNaN(d) ? 0 : d);
    }
    return sum;
}

const formatter = new Intl.NumberFormat('id-ID', {
    style: 'currency',
    currency: 'IDR',
    minimumFractionDigits: 0
})