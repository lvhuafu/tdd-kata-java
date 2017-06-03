# TDD Kata in Java [![Build Status](https://travis-ci.org/WowCoach/tdd-kata-java.svg?branch=master)](https://travis-ci.org/WowCoach/tdd-kata-java)

## TDD Practice
- [TDD Practice 1 - 简单集合操作](docs/TDD1.md)
- [TDD Practice 2 - 猜数字游戏](docs/TDD2.md)

## Project Board
- [ZenHub](https://github.com/WowCoach/tdd-kata-java#boards?repos=64041285)

## How to Start
#### Generate IntelliJ IDEA project
```
./gradlew cI idea  # Will clean idea first then idea
```

Open the `tdd-kata-java.ipr` using IntelliJ
```
open tdd-kata-java.ipr  # Using open or start depends on your OS
```

#### Run clean and build tasks
```
./gradlew  # Will run default clean build tasks
```

This will also run checkstyle, unit test and code coverage check

## Commit Standard:
```
[卡号][提交作者&Pair作者] - comment here
```

**Example:**
```
[M001][Shane&Water] - add the collection library
```

**Note:** [提交作者]和comment之间需要有`空格+minus+空格`，comment内容不要出现minus。

## Code to Notice:
- 代码中删去未使用的Import引用包，需要注意引用顺序。
- 类文件开始处不要出现 "/* xxx create xxx */" 这样自动生成的注释。
- 还有其他规范Checkstyle将会覆盖到。

## 生命游戏
- 细胞自动机（又称元胞自动机），名字虽然很深奥，但是它的行为却是非常美妙的。所有这些怎样实现的呢？我们可以把计算机中的宇宙想象成是一堆方格子构成的封闭空间，尺寸为N的空间就有N*N个格子。而每一个格子都可以看成是一个生命体，每个生命都有生和死两种状态，如果该格子生就显示蓝色，死则显示白色。每一个格子旁边都有邻居格子存在，如果我们把3*3的9个格子构成的正方形看成一个基本单位的话，那么这个正方形中心的格子的邻居就是它旁边的8个格子。
- 每个格子的生死遵循下面的原则：
- 1． 如果一个细胞周围有3个细胞为生（一个细胞周围共有8个细胞），则该细胞为生（即该细胞若原先为死，则转为生，若原先为生，则保持不变） 。
- 2． 如果一个细胞周围有2个细胞为生，则该细胞的生死状态保持不变；
- 3． 在其它情况下，该细胞为死（即该细胞若原先为生，则转为死，若原先为死，则保持不变）
