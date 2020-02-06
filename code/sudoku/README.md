# Sudoku (Z3 demo)

## Installing Z3 Java bindings from source

These directions should work to install the **Java bindings**
on a fresh Ubuntu 18.04 installation.

There may be easier ways to do this -- please see the Z3
page on Github for more info.

```
git clone https://github.com/Z3Prover/z3
cd z3
git clean -fx src
rm -rf build
JNI_HOME=`update-alternatives --list java | sed "s/java$/..\/include/g"` python scripts/mk_make.py --java
cd build && make
sudo make install
```

## Using the Z3 Java bindings

[API JavaDoc](https://z3prover.github.io/api/html/namespacecom_1_1microsoft_1_1z3.html)
