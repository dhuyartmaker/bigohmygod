class TrieNode {
    constructor() {
        this.children = {}; // children là một đối tượng chứa các node con
        this.value = 0; // Đánh dấu kết thúc của một từ
    }
}

class Trie {
    constructor() {
        this.root = new TrieNode(); // Khởi tạo root node
    }

    // Chèn một từ vào Trie
    insert(word) {
        let node = this.root;
        for (let char of word) {
            if (!node.children[char]) {
                node.children[char] = new TrieNode(); // Tạo một node mới nếu ký tự chưa tồn tại
            }
            node = node.children[char];
            node.value += 1;
        }
    }

    findWord(word) {
        let node = this.root;
        for (let char of word) {
            if (!node.children[char]) {
                return null;
            }
            node = node.children[char]
        }
        return node
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
    const n = parseInt(inp[i])
    i += 1;

    const trie = new Trie();

    for (;i < n + 1; i += 1) {
        const str = inp[i].split(" ")
        if (str[0] === 'add') {
            trie.insert(str[1])
        } else {
            const searchWord = trie.findWord(str[1]);
            if (searchWord) {
                console.log(searchWord.value)
            } else {
                console.log(0)
            }
        }
    }
}