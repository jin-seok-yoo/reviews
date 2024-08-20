document.addEventListener("DOMContentLoaded", function() {
  fetch('/api/reviews')
      .then(response => response.json())
      .then(data => {
          const reviewList = document.getElementById('reviewList');
          data.forEach(review => {
              const li = document.createElement('li');
              li.innerHTML = `
                  <h2>${review.title}</h2>
                  <p>${review.content}</p>
                  <p><strong>Rating:</strong> ${review.rating}</p>
                  ${review.imageUrl ? `<img src="${review.imageUrl}" alt="Review Image" style="max-width: 200px;">` : ''}
                  <p><small>작성자: ${review.author}, 작성일: ${review.createdAt}</small></p>
              `;
              reviewList.appendChild(li);
          });
      })
      .catch(error => console.error('Error fetching reviews:', error));
});
