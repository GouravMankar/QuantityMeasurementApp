# UC3 – Generic Quantity Class (DRY Refactor)

**Date:** 2026-02-22 

## Overview
Refactored duplicate classes into a single `QuantityLength` class.

## What Was Added
- `LengthUnit` enum
- Base-unit normalization (feet)
- Cross-unit equality and conversion
- Removal of duplicated logic

## Principles Followed
- DRY (Don't Repeat Yourself)
- Single Responsibility Principle
- Encapsulation
- Backward Compatibility
