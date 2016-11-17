#SmartCoordinatorLayout

[![CircleCI](https://circleci.com/gh/lalosoft/SmartCoordinatorLayout/tree/master.svg?style=shield)](https://circleci.com/gh/lalosoft/SmartCoordinatorLayout/tree/master)

Another way to use CoordinatorLayout and create fancy views with a couple of lines of code!

##Installation

###Gradle

Add the following lines on your module's build.gradle file
```gradle
compile 'lalosoft.android-utilities:smartcoordinatorlayout:1.0.6'
```


###Maven
```xml
<dependency>
  <groupId>lalosoft.android-utilities</groupId>
  <artifactId>smartcoordinatorlayout</artifactId>
  <version>1.0.6</version>
  <type>pom</type>
</dependency>
```

##Usage

For build SmartCoordinatorLayout, you need to provide a root id of your view. Something like this:

```java
ViewGroup rootView = (ViewGroup) findViewById(R.id.activity_base_root);
```

###Simple Usage

Build a [Simple RecyclerView](https://github.com/lalosoft/SmartCoordinatorLayout/blob/master/app/src/main/java/com/lalosoft/smartcoordinatorlayout/demo/simple/SimpleSmartRecyclerViewActivity.java)

```java
        CustomSmartRecyclerView smartRecyclerView = new CustomSmartRecyclerView(new CustomAdapter(this,
                createStringList(), new OnItemSelectedListener() {
            @Override
            public void onItemClick(int position) {
                // Handle the item click
            }
        }));

        // build SmartCoordinatorLayout
        SmartCoordinatorLayout
                smartCoordinatorLayout = new SmartCoordinatorLayout.Builder(this)
                .buildWithView(rootView)
                .addSmartComponent(smartRecyclerView)
                .build();

        smartCoordinatorLayout.setup();
```

---

Build a [Simple FAB](https://github.com/lalosoft/SmartCoordinatorLayout/blob/master/app/src/main/java/com/lalosoft/smartcoordinatorlayout/demo/simple/SimpleSmartFABActivity.java)

```java
        // instances FAB listener
        SmartFloatingActionButton.FloatingActionButtonListener fabListener = new SmartFloatingActionButton.FloatingActionButtonListener() {
            @Override
            public void onFABPressed() {
                // Handle the FAB click
            }
        };

        // build SmartCoordinatorLayout
        SmartCoordinatorLayout
                smartCoordinatorLayout = new SmartCoordinatorLayout.Builder(this)
                .buildWithView(rootView)
                .addSmartComponent(new SmartFloatingActionButton(fabListener))
                .build();

        smartCoordinatorLayout.setup();
```

---

Build a [Simple TabLayout](https://github.com/lalosoft/SmartCoordinatorLayout/blob/master/app/src/main/java/com/lalosoft/smartcoordinatorlayout/demo/simple/SimpleSmartTabLayoutActivity.java)

```java
        SmartFragmentTabLayout smartFragmentTabLayout = new SmartFragmentTabLayout(getSupportFragmentManager());
        smartFragmentTabLayout.addTab(new SmartFragmentTab("TAB1", fragment1));
        smartFragmentTabLayout.addTab(new SmartFragmentTab("TAB2", fragment2));
        smartFragmentTabLayout.addTab(new SmartFragmentTab("TAB3", fragment3));

        // build SmartCoordinatorLayout
        SmartCoordinatorLayout
                smartCoordinatorLayout = new SmartCoordinatorLayout.Builder(this)
                .buildWithView(rootView)
                .addSmartComponent(smartFragmentTabLayout)
                .build();

        smartCoordinatorLayout.setup();
```

###Complex Usage

Build a [RecyclerView with FAB](https://github.com/lalosoft/SmartCoordinatorLayout/blob/master/app/src/main/java/com/lalosoft/smartcoordinatorlayout/demo/complex/ComplexSmartRecyclerViewFABActivity.java)

```java
...
        SmartCoordinatorLayout
                smartCoordinatorLayout = new SmartCoordinatorLayout.Builder(this)
                .buildWithView(rootView)
                .addSmartComponent(smartRecyclerView) // Your SmartRecyclerView
                .addSmartComponent(new SmartFloatingActionButton(fabListener)) // Your SmartFAB
                .build();

        smartCoordinatorLayout.setup();
```

###Demo

You can [download](https://github.com/lalosoft/SmartCoordinatorLayout/releases/download/v1.0.6/SampleSmartCoordinatorLayout.apk) the apk in order to see the SmartCoordinatorLayout in action

##License
    Copyright 2016 SmartCoordinatorLayout

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
