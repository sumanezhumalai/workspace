# HTML & CSS Practice Projects

A comprehensive collection of practice projects documenting my learning journey through HTML and CSS fundamentals. Each project focuses on specific concepts with detailed comments explaining properties, patterns, and best practices.

---

## 📚 Table of Contents

### Main Practice Projects
1. [ButtonPosition - CSS Positioning & Transforms](#1-buttonposition)
2. [BackgroundsFiltersGradients - Backgrounds, Filters & Gradients](#2-backgroundsfiltersgradients)
3. [Flexbox - Flexbox Layout System](#3-flexbox)
4. [GridProject - CSS Grid & Responsive Design](#4-gridproject)
5. [AnimationsWork - CSS Animations](#5-animationswork)
6. [CantileverResponsive - Responsive Typography](#6-cantileverresponsive)
7. [BlogPost - Typography & CSS Units](#7-blogpost)
8. [PricingUIFlexbox - Advanced Flexbox UI](#8-pricinguiflexbox)
9. [CVProject - Portfolio Sections](#9-cvproject)

### Additional Practice Projects
10. [GridLayoutBasics - Grid Fundamentals](#10-gridlayoutbasics)
11. [MediaQueriesResponsive - Responsive Breakpoints](#11-mediaqueriesresponsive)
12. [PseudoElements - ::before, ::after, Custom Checkboxes](#12-pseudoelements)
13. [ModernCSSFeatures - CSS Variables & calc()](#13-moderncssfeatures)
14. [ArtistPortfolio - Portfolio Layout](#14-artistportfolio)
15. [SumanPortfolio - Personal Portfolio](#15-sumanportfolio)

---

## 1. ButtonPosition

**File:** `positioning-transforms-gradients.css`

### Topics Covered
- **CSS Positioning**: `absolute`, `relative`, `z-index`
- **Transform Properties**: `translateY`, `scale`, `rotate3d`, `transform-origin`
- **Transitions**: Smooth hover animations
- **Gradients**: `linear-gradient`, `radial-gradient`, `conic-gradient`, `repeating-linear-gradient`
- **Box Shadow**: Multiple shadow layers

### Key Concepts
```css
/* position: relative creates positioning context for absolute children */
.msg-btn {
  position: relative;
  z-index: 1;
}

/* position: absolute positions relative to nearest positioned ancestor */
.msg-count {
  position: absolute;
  top: -14px;
  right: -14px;
  z-index: 2;
}

/* transform doesn't affect document flow */
.msg-btn:hover {
  transform: translateY(-4px);
}
```

### Important Notes
- `z-index` only works on positioned elements (not `static`)
- `position: absolute` removes element from document flow
- `transform-origin` changes the pivot point for transformations
- Radial gradients radiate from a point, linear gradients flow along a line

---

## 2. BackgroundsFiltersGradients

**Folder:** `BackgroundsFiltersGradients/`  
**File:** `backgrounds-filters-gradients.css`

### Topics Covered
- **Background Properties**: `background-size`, `background-position`, `background-repeat`, `background-clip`
- **CSS Filters**: `blur()`, `grayscale()`, `contrast()`, `hue-rotate()`
- **Gradient Types**: Linear, radial, conic, repeating linear
- **Background Layering**: Images + colors

### Key Concepts
```css
/* background-size: cover scales to fill container */
.box-3 {
  background-size: cover;
  background-position: center;
  filter: contrast(1.5);
}

/* Radial gradient from specific position */
.box-5 {
  background-image: radial-gradient(
    circle at top,
    rgb(176, 200, 249) 30%,
    rgb(99, 119, 188),
    rgb(9, 28, 75) 95%
  );
}

/* Repeating patterns */
.box-7 {
  background-image: repeating-linear-gradient(
    45deg,
    rgb(70, 70, 212),
    rgb(213, 71, 71) 10%
  );
}
```

### Important Notes
- `background-clip` defines where background is painted (border-box, padding-box, content-box)
- Filters can be chained: `filter: blur(2px) contrast(1.2);`
- `background-size: cover` maintains aspect ratio but may crop
- Conic gradients create circular sweeps (like pie charts)

---

## 3. Flexbox

**Files:** 
- `flexbox-timeline-navbar.css` (Layout patterns)
- `flexbox-sizing-properties.css` (Sizing behavior)

### Topics Covered
- **Flexbox Layout**: `justify-content`, `align-items`, `align-self`, `flex-direction`
- **Flex Item Properties**: `flex-grow`, `flex-shrink`, `flex-basis`, `order`
- **Navbar Patterns**: Horizontal layout with space distribution
- **Timeline Layout**: Alternating content with `align-self`

### Key Concepts
```css
/* Container properties */
.container {
  display: flex;
  flex-direction: column;
  justify-content: space-around;
  align-items: center;
}

/* Individual item override */
.special {
  align-self: flex-end;
  order: 0;
}

/* Flex sizing */
.sidebar {
  flex: 0 1 auto; /* grow shrink basis */
}
```

### Important Notes
- Flexbox is 1-dimensional (row OR column)
- `justify-content` aligns along main axis
- `align-items` aligns along cross axis
- `align-self` overrides `align-items` for individual items
- `order` changes visual order without changing HTML
- `flex-grow` determines space allocation (higher = more space)

---

## 4. GridProject

**File:** `grid-responsive-portfolio.css`

### Topics Covered
- **CSS Grid**: `grid-template-areas`, `grid-gap`, `grid-area`
- **Responsive Design**: Media queries at 1100px and 780px breakpoints
- **Hamburger Menu**: Animated menu icon with @keyframes
- **Mobile Navigation**: Drawer pattern with transform
- **Image Overlays**: Hover effects with opacity transitions

### Key Concepts
```css
/* Named grid areas - semantic layout */
.picture-grid {
  display: grid;
  grid-gap: 10px;
  grid-template-areas:
    "eth eth alphabet"
    "eth eth traveler"
    "cube astro traveler";
}

#eth {
  grid-area: eth;
}

/* Mobile drawer navigation */
.mobilenav {
  position: fixed;
  transform: translateX(120px); /* Hidden */
  transition: transform 0.7s;
}

.openDrawer {
  transform: translateX(-1px); /* Visible */
}
```

### Important Notes
- `grid-template-areas` provides visual, semantic layout definition
- Repeated names in grid-template-areas span multiple cells
- Media queries should be organized by breakpoint size
- `animation-fill-mode: forwards` maintains final animation state
- Fixed positioning removes element from document flow

---

## 5. AnimationsWork

**Folder:** `AnimationsWork/KeyframesBasics/`  
**File:** `keyframes-animations.css`

### Topics Covered
- **@keyframes**: Animation definition with 0%-100% or from-to syntax
- **Animation Properties**: `duration`, `timing-function`, `delay`, `iteration-count`, `direction`
- **Animation Fill Mode**: `forwards`, `backwards`, `both`
- **Animation Play State**: `running`, `paused`
- **Staggered Animations**: Using nth-child with delays

### Key Concepts
```css
/* Animation with fill-mode: backwards */
.box {
  animation: move 2s ease-in-out 0.6s backwards;
}

/* Keyframe definition */
@keyframes move {
  0% {
    transform: translateX(0%);
    background-color: rgb(230, 145, 174);
  }
  100% {
    transform: translateX(300px);
    background-color: olive;
  }
}

/* Staggered delays */
.loader span:nth-child(2) {
  animation: jump 1s ease-in-out 0.333s infinite;
}
```

### Important Notes
- `animation-fill-mode: backwards` applies 0% state during delay
- `animation-fill-mode: forwards` retains final state after completion
- `animation-fill-mode: both` combines forwards + backwards
- `infinite` makes animation loop forever
- `alternate` reverses direction each iteration
- Timing functions: `ease`, `ease-in`, `ease-out`, `ease-in-out`, `linear`

---

## 6. CantileverResponsive

**File:** `responsive-typography.css`

### Topics Covered
- **Responsive Typography**: Scaling font sizes with media queries
- **Text Shadow**: Multiple layered shadows for effects
- **Responsive Layout**: Width adjustments at different breakpoints
- **Media Query Breakpoints**: 1700px, 1440px, 1200px, 800px

### Key Concepts
```css
/* Multi-layered text shadow */
span {
  text-shadow:
    0 -6.25px #0c2ffb,
    0 -12.5px #2cfcfd,
    0 6.25px #fb203b,
    0 12.5px #fefc4b;
}

/* Responsive scaling */
@media only screen and (max-width: 1200px) {
  h1 {
    font-size: 70px; /* Reduced from 100px */
  }
  span {
    text-shadow: /* Adjusted shadow offsets */
      0 -3.25px #0c2ffb,
      0 -6.5px #2cfcfd;
  }
}
```

### Important Notes
- Font sizes should scale proportionally across breakpoints
- Text shadows should also scale to maintain visual effect
- Use relative widths (percentages) for responsive containers
- Mobile-first approach: start with smallest screen, then scale up

---

## 7. BlogPost

**File:** `typography-units.css`

### Topics Covered
- **Typography Properties**: `font-family`, `font-size`, `font-weight`, `line-height`, `letter-spacing`
- **Text Transform**: `uppercase`, `capitalize`, `lowercase`
- **CSS Units**: `px`, `em`, `rem` - differences and use cases
- **Semantic HTML**: Using proper heading hierarchy
- **Text Decoration**: Underlines with `text-decoration` and `text-underline-offset`

### Key Concepts
```css
/* px - Fixed pixel values */
body {
  font-size: 16px;
}

/* em - Relative to parent element */
.nested {
  font-size: 1.5em; /* 16px × 1.5 = 24px */
}

/* rem - Relative to root element */
p {
  font-size: 2rem; /* root × 2 = 32px if root is 16px */
}

/* Text transformation */
h3 {
  text-transform: capitalize; /* First Letter Of Each Word */
}
```

### Important Notes
- **px**: Simple but not responsive
- **em**: Relative to parent (can compound in nested elements)
- **rem**: Relative to root (consistent, easier to manage)
- Use `rem` for responsive typography
- Text-transform doesn't change HTML content, only visual display
- Proper heading hierarchy (h1→h2→h3) improves SEO and accessibility

---

## 8. PricingUIFlexbox

**Folder:** `PricingUIFlexbox/`  
**File:** `flexbox-pricing-ui.css`

### Topics Covered
- **Advanced Flexbox**: Complex nested layouts
- **Pseudo-classes**: `:hover`, `:active`, `.on` state toggles
- **UI Patterns**: Toggle switches, pricing cards, sliders
- **Transform Effects**: Scale on hover
- **Gradient Backgrounds**: Linear gradients for visual interest
- **Absolute Positioning**: Slider elements, decorative elements

### Key Concepts
```css
/* Card hover effect */
.card:hover {
  cursor: pointer;
  transform: scale(1.05);
}

/* Toggle switch styling */
.toggles .on {
  color: rgb(83, 49, 153);
  background-color: white;
  border-radius: 20px;
}

/* Nested flexbox for complex layouts */
.card-wrapper {
  display: flex;
  justify-content: space-between;
}

/* Gradient backgrounds */
.progress {
  background: linear-gradient(
    90deg,
    rgba(2, 0, 36, 1) 0%,
    rgba(83, 49, 153, 1) 100%
  );
}
```

### Important Notes
- Nested flexbox containers provide fine-grained layout control
- `transform: scale()` is good for hover feedback
- Combine flexbox with absolute positioning for complex UI elements
- Responsive design: wrap cards with `flex-wrap` on smaller screens
- Box shadows create depth perception (important for card designs)

---

## 9. CVProject

**File:** `portfolio-sections.css`

### Topics Covered
- **Multi-section Layouts**: Header, main content, footer
- **Two-column Patterns**: Flexbox-based column layouts
- **Hero Sections**: Large header with navbar
- **List Styling**: Removing default bullets, custom formatting
- **Flexbox Navbar**: `justify-content: space-between` pattern

### Key Concepts
```css
/* Hero section with navbar */
.navbar {
  display: flex;
  justify-content: space-between;
  align-items: center;
}

/* Two-column layout pattern */
.two-column {
  display: flex;
  gap: 40px;
}

/* Custom list styling */
.skills {
  list-style: none;
  display: grid;
  grid-template-columns: repeat(2, 1fr);
}
```

### Important Notes
- Hero sections typically combine navbar + large heading + CTA
- Two-column layouts are versatile (sidebar+content, label+value)
- Remove default list styles for custom designs
- Flexbox with `space-between` creates professional navbar layouts
- Footer design should be visually separated from main content

---

## 10. GridLayoutBasics

**Folder:** `GridLayoutBasics/`  
**File:** `app.css`

### Topics Covered
- Basic CSS Grid layout
- Grid container properties (`display: grid`)
- Grid item positioning
- Grid columns and rows
- Simple grid patterns

### Key Concepts
```css
.container {
  display: grid;
  grid-template-columns: repeat(3, 1fr);
  grid-gap: 10px;
}

/* Individual item control */
.first {
  grid-column: span 2;
}
```

---

## 11. MediaQueriesResponsive

**Folder:** `MediaQueriesResponsive/`  
**File:** `index.css`

### Topics Covered
- Media query syntax and breakpoints
- Responsive navigation bars
- Responsive grid layouts
- Viewport-based styling
- Mobile-first vs desktop-first approaches

### Key Concepts
```css
/* Mobile first approach */
@media (min-width: 768px) {
  .box-container {
    grid-template-columns: repeat(3, 1fr);
  }
}

@media (min-width: 1024px) {
  .box-container {
    grid-template-columns: repeat(4, 1fr);
  }
}
```

---

## 12. PseudoElements

**Folder:** `PseudoElements/`  
**File:** `styles.css`

### Topics Covered
- `::before` and `::after` pseudo-elements
- Custom checkbox styling
- Quote marks with pseudo-elements
- Loading spinners
- Content generation with CSS

### Key Concepts
```css
/* Custom checkbox with ::before */
.toggle::before {
  content: "";
  position: absolute;
  /* styling for custom appearance */
}

/* Quote marks */
blockquote::before {
  content: "\201C"; /* Left double quote */
}

blockquote::after {
  content: "\201D"; /* Right double quote */
}
```

### Important Notes
- Pseudo-elements require `content` property (even if empty)
- Commonly used for decorative elements
- Don't show up in DOM but are rendered visually
- Can't be selected or interacted with

---

## 13. ModernCSSFeatures

**Folder:** `ModernCSSFeatures/`  
**Subfolders:** `variables/`, `calcFunction/`

### Topics Covered
- **CSS Variables (Custom Properties)**: Define reusable values
- **calc() Function**: Perform calculations in CSS
- **var() Function**: Use CSS variables
- Dynamic theming and color schemes

### Key Concepts
```css
/* CSS Variables */
:root {
  --primary-color: #3949ab;
  --spacing-unit: 16px;
  --font-size-base: 1rem;
}

.element {
  color: var(--primary-color);
  padding: var(--spacing-unit);
}

/* calc() Function */
.sidebar {
  width: calc(100% - 300px);
  height: calc(100vh - 60px);
  padding: calc(var(--spacing-unit) * 2);
}
```

### Important Notes
- CSS variables cascade and can be overridden
- `calc()` can mix units (%, px, em, rem, vh, vw)
- Variables enable theming without JavaScript
- Can be changed dynamically with JavaScript
- `:root` is essentially the `<html>` element

---

## 14. ArtistPortfolio

**Folder:** `ArtistPortfolio/`

### Topics Covered
- Grid-based portfolio layout
- Image galleries
- Hover effects on portfolio items
- Responsive grid columns
- Portfolio presentation patterns

---

## 15. SumanPortfolio

**Folder:** `SumanPortfolio/`

### Topics Covered
- Personal branding elements
- Custom styling and theming
- Portfolio presentation patterns
- Personal project showcase

---

## 🎯 Key Learning Outcomes

### CSS Positioning
- Understand the difference between `static`, `relative`, `absolute`, and `fixed`
- Master z-index stacking contexts
- Use positioning for overlays and badges

### Flexbox Mastery
- Build responsive navigation bars
- Create complex layouts with nested flexbox
- Understand main axis vs cross axis
- Master flex-grow, flex-shrink, and flex-basis

### CSS Grid
- Use grid-template-areas for semantic layouts
- Build responsive grids with media queries
- Understand grid vs flexbox use cases

### Animations & Transitions
- Create smooth UI interactions
- Build loading spinners and loaders
- Master @keyframes and animation properties
- Understand fill-mode behavior

### Responsive Design
- Implement mobile-first approach
- Use media queries effectively
- Scale typography responsively
- Build hamburger menus and mobile navigation

### Typography
- Understand px, em, and rem units
- Apply text transformations
- Create proper heading hierarchies
- Use custom web fonts

---

## 📝 Notes on Code Organization

### Commenting Strategy
All code includes:
- **Section headers**: Clearly marked with visual separators
- **Property explanations**: What each property does
- **Concept notes**: Why certain patterns are used
- **Best practices**: Recommendations for future reference
- **Preserved experiments**: Commented code showing alternative approaches

### Folder & File Naming Convention

**Folders** are named in PascalCase (descriptive and concept-based):
- `ButtonPosition/` - CSS Positioning practice
- `BackgroundsFiltersGradients/` - Background & filter techniques
- `AnimationsWork/` - Animation exercises
- `PricingUIFlexbox/` - Advanced UI patterns
- `ModernCSSFeatures/` - CSS Variables & calc()

**Files** are named descriptively based on the concepts they cover:
- `positioning-transforms-gradients.css`
- `backgrounds-filters-gradients.css`
- `flexbox-timeline-navbar.css`
- `grid-responsive-portfolio.css`
- `keyframes-animations.css`

This consistent naming makes it easy to find specific concepts when reviewing.

---

## 🔄 Future Reference Guidelines

### When to Use What

**Flexbox vs Grid:**
- **Flexbox**: 1-dimensional layouts (rows OR columns), navbars, cards in a row
- **Grid**: 2-dimensional layouts (rows AND columns), page layouts, image galleries

**Positioning:**
- **Static**: Default, normal document flow
- **Relative**: Small adjustments, positioning context for absolute children
- **Absolute**: Overlays, badges, tooltips (removed from flow)
- **Fixed**: Sticky headers, floating buttons (removed from flow, viewport-relative)

**CSS Units:**
- **px**: Borders, small fixed values
- **em**: When you want scaling based on parent
- **rem**: Typography, spacing (most responsive)
- **%**: Widths, responsive layouts

**Animation vs Transition:**
- **Transition**: Simple state changes (hover, focus)
- **Animation**: Complex sequences, looping, auto-start

---

## ⚠️ Common Pitfalls to Remember

1. **Z-index doesn't work on static elements** - must have position value
2. **Flexbox doesn't automatically wrap** - need `flex-wrap: wrap`
3. **Em units compound in nested elements** - prefer rem for consistency
4. **Transform doesn't affect document flow** - surrounding elements don't move
5. **Background-size: cover may crop images** - use `background-position` to control
6. **Absolute positioning needs a positioned parent** - add `position: relative`
7. **Animation fill-mode is crucial** - without it, elements snap back after animation
8. **Grid template areas need matching names** - typos break the layout
9. **Media queries should be min-width for mobile-first** - or max-width for desktop-first
10. **Filter affects entire element** - can't filter just part of it

---

## 🚀 Practice Approach

Each project represents:
- ✅ Learning a new concept
- ✅ Experimenting with variations (commented code)
- ✅ Understanding edge cases
- ✅ Documenting for future reference

**All commented code is intentionally preserved** - it represents experiments and alternative approaches that are valuable for learning.

---

## 📖 Resources Used

- MDN Web Docs
- CSS-Tricks
- Google Fonts
- Practice images from various sources

---

*This practice directory represents my journey learning HTML & CSS fundamentals. Each project builds on previous knowledge while introducing new concepts. Comments are detailed to serve as future reference material.*
