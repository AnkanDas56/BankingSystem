
document.addEventListener("DOMContentLoaded", () => {
  const items = document.querySelectorAll(".reveal");
  const observer = new IntersectionObserver((entries) => {
    entries.forEach(entry => {
      if (entry.isIntersecting) {
        entry.target.classList.add("show");
        observer.unobserve(entry.target);
      }
    });
  }, { threshold: .12 });
  items.forEach((item, i) => {
    item.style.transitionDelay = `${Math.min(i * 70, 280)}ms`;
    observer.observe(item);
  });
});
