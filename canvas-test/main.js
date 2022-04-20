window.addEventListener('load', init);

const DATA = [{ start: 100, end: 50 }, { start: 150, end: 35 }, { start: 30, end: 90 }, { start: 10, end: 200 }];

function init() {
  const MAIN = new Main(DATA);
  MAIN.start();
}

class Main {
  #container = document.getElementById("container");

  constructor(data) {
    this.data = this.config(data);
    this.cx = this.#container.getContext("2d");
  }

  config(data) {
    this.#container.width = 800;
    this.#container.height = 500;
    return data.map((value) => {
      return { color: '#' + Math.floor(Math.random() * 16777215).toString(16), ...value }
    });
  }

  start() {
    const TOTAL = this.data.length;
    const INIT_X = 12;
    for (let i = 0; i < TOTAL; i++) {
      let current = this.data[i];
      this.cx.beginPath();
      this.cx.fillStyle = current.color;
      this.cx.arc(INIT_X, current.start, 10, 0, 2 * Math.PI);
      this.cx.arc((this.#container.width - INIT_X), current.end, 10, 0, 2 * Math.PI);
      this.cx.fill();
      this.drawLine(current);
    }
  }

  drawLine(data) {
    this.cx.strokeStyle = data.color;
    this.cx.lineWidth = 3;
    this.cx.lineTo(10, data.start);
    this.cx.moveTo((this.#container.width - 10), data.end);
    this.cx.stroke();
  }

}
