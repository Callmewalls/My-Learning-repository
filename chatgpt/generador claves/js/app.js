const board = document.getElementById('board');
const resetButton = document.getElementById('reset');
let isGameOver = false;
let mineCount = 10;

resetButton.addEventListener('click', () => {
  resetGame();
});

function resetGame() {
  isGameOver = false;
  board.innerHTML = '';
  const cells = [];
  for (let i = 0; i < 10; i++) {
    cells[i] = [];
    for (let j = 0; j < 10; j++) {
      cells[i][j] = createCell(i, j);
      board.appendChild(cells[i][j]);
    }
  }
  addMines(cells);
  updateMineCount();
}

function createCell(row, col) {
  const cell = document.createElement('div');
  cell.classList.add('cell');
  cell.dataset.row = row;
  cell.dataset.col = col;
  cell.addEventListener('click', () => {
    revealCell(cell);
  });
  cell.addEventListener('contextmenu', (e) => {
    e.preventDefault();
    toggleFlag(cell);
  });
  return cell;
}

function addMines(cells) {
  let count = 0;
  while (count < mineCount) {
    const row = Math.floor(Math.random() * 10);
    const col = Math.floor(Math.random() * 10);
    if (!cells[row][col].classList.contains('mine')) {
      cells[row][col].classList.add('mine');
      count++;
    }
  }
}

function revealCell(cell) {
  if (isGameOver || cell.classList.contains('revealed') || cell.classList.contains('flagged')) {
    return;
  }

  if (cell.classList.contains('mine')) {
    gameOver();
  } else {
    const row = parseInt(cell.dataset.row);
    const col = parseInt(cell.dataset.col);
    const minesAround = countMinesAround(row, col);
    cell.classList.add('revealed');
    cell.textContent = minesAround === 0 ? '' : minesAround;
    if (minesAround === 0) {
      revealEmptyCells(cells, row, col);
    }
    checkWin();
  }
}

function toggleFlag(cell) {
  if (isGameOver || cell.classList.contains('revealed')) {
    return