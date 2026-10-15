# 🧩 L-Shape Tromino Tiling Visualizer

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Algorithm](https://img.shields.io/badge/Algorithm-Divide%20%26%20Conquer-blue?style=for-the-badge)
![License](https://img.shields.io/badge/License-MIT-green?style=for-the-badge)

An interactive **Java Swing** application that visualizes the classical **Divide and Conquer** algorithm solving the Tromino Tiling problem on a $2^n \times 2^n$ board with an arbitrary missing square.

---

## 📸 Demo & Visualization

> *Uygulamayı çalıştırdığınızda aldığınız bir ekran görüntüsünü repoya `screenshot.png` olarak ekleyip buraya bağlayabilirsiniz:*
<!-- ![App Screenshot](screenshot.png) -->

---

## ⚡ How It Works (Divide & Conquer)
The board of dimension $2^n \times 2^n$ is recursively split into 4 equal quadrants ($2^{n-1} \times 2^{n-1}$):
1. Locate which quadrant contains the missing cell (or already placed tromino).
2. Place a single **L-shaped tromino** at the center, covering one corner cell of each of the other 3 quadrants.
3. Now all 4 quadrants effectively have exactly one "missing" square.
4. Recursively tile each sub-board until the base case ($2 \times 2$ or $1 \times 1$) is reached.

### ⏱️ Complexity
* **Time Complexity:** $\mathcal{O}(4^n) = \mathcal{O}(N^2)$ where $N = 2^n$. Every cell is visited and colored exactly once.
* **Space Complexity:** $\mathcal{O}(n)$ recursive call stack depth.

---

## 🚀 Getting Started

### Prerequisites
* Java JDK 8 or higher installed on your machine.

### Installation & Run
1. Clone the repository:
   ```bash
   git clone [https://github.com/dogukanyusaboz-ai/tromino-tiling.git](https://github.com/dogukanyusaboz-ai/tromino-tiling.git)
   cd tromino-tiling
