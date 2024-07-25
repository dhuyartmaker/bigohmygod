class TrieNode {
    constructor() {
        this.children = {};
        this.isEndOfWord = false;
    }
}

class Trie {
    constructor() {
        this.root = new TrieNode();
    }

    insert(word) {
        let node = this.root;
        for (let char of word) {
            if (!node.children[char]) {
                node.children[char] = new TrieNode();
            }
            node = node.children[char];
            if (node.isEndOfWord) {
                return false;
            }
        }
        node.isEndOfWord = true;
        if (Object.keys(node.children).length > 0) {
            return false;
        }
        return true;
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
    let index = 0;
    const T = parseInt(inp[index]);
    index += 1;

    const trie = new Trie();
    let isConsistent = true;
    let wordBadCase = ''
    for (let i = 0; i < T; i++) {
        const word = inp[index + i];
        if (!trie.insert(word)) {
            isConsistent = false;
            wordBadCase = word;
            break;
        }
    }

    if (isConsistent) {
        console.log(`GOOD SET`);
    } else {
        console.log(`BAD SET`);
        console.log(wordBadCase)
    }
}
