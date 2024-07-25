class TrieNode {
    constructor() {
        this.children = {}; // children là một đối tượng chứa các node con
        this.value = -1; // Đánh dấu kết thúc của một từ
    }
}

class Trie {
    constructor() {
        this.root = new TrieNode(); // Khởi tạo root node
    }

    // Chèn một từ vào Trie
    insert(word, value) {
        let node = this.root;
        for (let char of word) {
            if (!node.children[char]) {
                node.children[char] = new TrieNode(); // Tạo một node mới nếu ký tự chưa tồn tại
            }
            node = node.children[char];
            node.value = Math.max(value, node.value); // Đánh dấu kết thúc từ
        }
    }

    getMaxValue(word) {
        let node = this.root;
        for (let char of word) {
            if (!node.children[char]) {
                return -1;
            }
            node = node.children[char]
        }
        return node.value
    }
}

const readline = require('readline');

const rl = readline.createInterface({
	input: process.stdin,
	output: process.stdout
});

let input = [];
rl.on('line', (line) => {
	if (line.trim() === '0') {
		rl.close();
	} else {
		input.push(line);
	}
});

rl.on('close', () => {
	solveProblem(input);
});

function solveProblem(inp) {
    let i = 0
    const nq = `${inp[i]}`.split(" ");
    const n = parseInt(nq[0])
    const q = parseInt(nq[1])
    i += 1;

    const trie = new Trie();
    for (;i < n + 1; i += 1) {
        const str = inp[i].split(" ")
        trie.insert(str[0], parseInt(str[1]));
    }
    for (; i < q + n + 1; i += 1) {
        console.log(trie.getMaxValue(inp[i]))
    }
}