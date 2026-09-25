"use strict";

// ============================================================
//  IMPORTS — Comment/uncomment to run only what you need
//  Each file exports a `run()` function. We rename it on import
//  so each concept has its own callable name.
// ============================================================

// === BASICS ===
import { run as runBasic } from "./Basics/basic.js";
import { run as runFunctions } from "./Basics/functions.js";
import { run as runArrays } from "./Basics/arrays.js";
import { run as runObjects } from "./Basics/objects.js";
import { run as runLoops } from "./Basics/loops.js";
import { run as runStrings } from "./Basics/strings.js";
import { run as runThis } from "./Basics/thisKeyword.js";

// === DATA STRUCTURES & OPERATORS ===
import { run as runObjRef } from "./DsaAndOperators/ObjRef.js";
import { run as runDestructArray } from "./DsaAndOperators/DestructArray.js";
import { run as runDestructObj } from "./DsaAndOperators/DestructObj.js";
import { run as runSpreadOp } from "./DsaAndOperators/SpreadOp.js";
import { run as runRestPattern } from "./DsaAndOperators/RestPatternAndParameters.js";
import { run as runShortCircuit } from "./DsaAndOperators/ShortCircuting.js";
import { run as runLogicalAssignment } from "./DsaAndOperators/LogicalAssignmentOp.js";
import { run as runOptionalChaining } from "./DsaAndOperators/OptionalChaining.js";
import { run as runObjectLooping } from "./DsaAndOperators/ObjectLooping.js";
import { run as runEnhancedObjLiteral } from "./DsaAndOperators/EnhObjLiteral.js";
import { run as runSet } from "./DsaAndOperators/Set.js";
import { run as runMap } from "./DsaAndOperators/Map.js";

// === PROBLEMS / PRACTICE ===
import { run as runThermometer } from "./Problems/thermometer.js";
import { run as runTemperature } from "./Problems/temperature.js";
import { run as runFootball } from "./Problems/football.js";
// import { run as runStringProblem } from "./Problems/string.js"; // No export in this file

// ============================================================
//  EXECUTION — Call only the concept you want to practice
//  Uncomment the run() function you want to execute
// ============================================================

// === BASICS ===
// runBasic();
// runFunctions();
// runArrays();
// runObjects();
// runLoops(); // has run() at end of file
// runStrings(); // has run() at end of file
// runThis();

// === DATA STRUCTURES & OPERATORS ===
// runObjRef();
// runDestructArray();
// runDestructObj();
// runSpreadOp();
// runRestPattern();
// runShortCircuit();
// runLogicalAssignment();
// runOptionalChaining(); // has run() at end of file
// runObjectLooping(); // has run() at end of file
// runEnhancedObjLiteral(); // has run() at end of file
// runSet(); // has run() at end of file
// runMap(); // has run() at end of file

// === PROBLEMS / PRACTICE ===
// runThermometer();
// runTemperature();
// runFootball(); // has run() at end of file

// ============================================================
//  NOTES:
//  • Some files already call run() internally (marked with comment above)
//  • To execute on Node terminal: uncomment desired run() and run: node script.js
//  • To execute in browser: import this file in index.html and check console
// ============================================================
